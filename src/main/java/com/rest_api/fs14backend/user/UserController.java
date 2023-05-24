package com.rest_api.fs14backend.user;

//import com.rest_api.fs14backend.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<User> findAll() {
    System.out.println("we are inside users");
    return userService.findAll();
  }
  @PostMapping("/signup")
  public User signup(@RequestBody User user) {
    return userService.signup(user);
  }

  @PostMapping("/signin")
  public Map<String, String> login(@RequestBody AuthRequest authRequest) {
    return userService.login(authRequest);
  }
}
