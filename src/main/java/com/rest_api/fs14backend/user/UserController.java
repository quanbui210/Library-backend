package com.rest_api.fs14backend.user;

//import com.rest_api.fs14backend.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")

public class UserController {

//  @Autowired
//  private AuthenticationManager authenticationManager;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;
//  @Autowired
//  private PasswordEncoder passwordEncoder;
////  @Autowired
//  private JwtUtils jwtUtils;

  @GetMapping
  public List<User> findAll() {
    System.out.println("we are inside users");
    return userService.findAll();
  }
  @PostMapping("/signup")
  public User signup(@RequestBody User user) {
    return userService.signup(user);
  }

//  @PostMapping("/signin")
//  public String login(@RequestBody AuthRequest authRequest){
//
//    authenticationManager.authenticate(
//      new UsernamePasswordAuthenticationToken(
//        authRequest.getUsername(),
//        authRequest.getPassword()
//      )
//    );
//
//    User user = userRepository.findByUsername(authRequest.getUsername());
//
//    return jwtUtils.generateToken(user);
//  }
//
//  @PostMapping("/signup")
//  public User signup(@RequestBody User user) {
//
//    User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
//    userRepository.save(newUser);
//
//    return newUser;
//  }

}
