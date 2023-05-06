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
//      Book book2 = new Book(
//              123433, "Book2", null, "This is Book2",
//              Book.Status.AVAILABLE, "Publisher2", category1, author1
//      );
//      Book book3 = new Book(
//              123432, "Book3", null, "This is Book3",
//              Book.Status.AVAILABLE, "Publisher3", category1, author2
//      );
//      Book book4 = new Book(
//              123431, "Book4", null, "This is Book4",
//              Book.Status.BORROWED, "Publisher4", category1, author3
//      );
//      Book book5 = new Book(
//              123430, "Book5", null, "This is Book5",
//              Book.Status.AVAILABLE, "Publisher5", category1, author4
//      );
//      repository.saveAll(
//              List.of(book2, book3, book4, book5)
//      );
//    };
//  }
//}
//
//
