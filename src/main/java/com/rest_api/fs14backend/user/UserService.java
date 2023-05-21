package com.rest_api.fs14backend.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  public List<User> findAll() {
    return userRepository.findAll();
  }
  public User signup(User user) {
    User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
    userRepository.save(newUser);
    return newUser;
  }
}
