//package com.rest_api.fs14backend.author;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//@ComponentScan("com.example.demo")
//public class AuthorConfig {
//  @Bean
//  CommandLineRunner commandLineRunner2(AuthorRepository repository) {
//    return args -> {
//      Author a1 = new Author(
//              "Quan1", "A1"
//      );
//      Author a2 = new Author(
//              "Quan2", "A2"
//      );
//      Author a3 = new Author(
//              "Quan3", "A31"
//      );
//
//      repository.saveAll(
//              List.of(a1, a2, a3)
//      );
//    };
//  }
//}
//
//
