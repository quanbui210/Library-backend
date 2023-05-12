//package com.rest_api.fs14backend.book;
//
//import com.rest_api.fs14backend.author.Author;
//import com.rest_api.fs14backend.author.AuthorRepository;
//import com.rest_api.fs14backend.category.Category;
//import com.rest_api.fs14backend.category.CategoryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class BookConfig {
//  @Bean
//  CommandLineRunner commandLineRunner(BookRepository repository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
//    Category category1 = new Category("Fiction");
//    categoryRepository.save(category1);
//    Author author1 = new Author("JK Rowling", "Author description...");
//    Author author2 = new Author("John Doe", "Author description...");
//    Author author3 = new Author("Jane Smith", "Author description...");
//    Author author4 = new Author("Ole", "Author description...");
//    authorRepository.save(author1);
//    authorRepository.save(author2);
//    authorRepository.save(author3);
//    authorRepository.save(author4);
//    return args -> {
//      BookRequest book4 = new BookRequest(
//             12343, "BookREQ", null, "This is Book", Book.Status.AVAILABLE, "Me", author1.getId(), category1.getId()
//      );
//      BookRequest book3 = new BookRequest(
//              12343, "BookREQ", null, "This is Book", Book.Status.AVAILABLE, "Me", author1.getId(), category1.getId()
//      );
//      repository.saveAll(
//              List.of( book3, book4)
//      );
//    };
//  }
//}
//
//
