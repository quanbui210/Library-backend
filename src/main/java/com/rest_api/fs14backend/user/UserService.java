package com.rest_api.fs14backend.user;

import com.rest_api.fs14backend.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtUtils jwtUtils;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User signup(User user) {
    User existingUser = userRepository.findByUsername(user.getUsername());
    if (existingUser != null) {
      throw new IllegalArgumentException("Username already exists");
    }
    User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
    newUser.setRole(UserRole.USER);
    userRepository.save(newUser);
    return newUser;
  }

  public Map<String, Object> login(AuthRequest authRequest) {
    Map<String, Object> response = new HashMap<>();

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            )
    );

    User user = userRepository.findByUsername(authRequest.getUsername());

    // Generate the token
    String token = jwtUtils.generateToken(user);

    // Create a map to hold the token and user data
    Map<String, Object> userData = new HashMap<>();
    userData.put("id", user.getId());
    userData.put("username", user.getUsername());
    // Add any other user fields you want to include in the response

    // Put the token and user data in the response map
    response.put("token", token);
    response.put("userData", userData);

    return response;
  }
}
