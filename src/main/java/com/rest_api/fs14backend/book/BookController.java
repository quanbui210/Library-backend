package com.rest_api.fs14backend.book;

import com.rest_api.fs14backend.author.AuthorService;
import com.rest_api.fs14backend.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
  @Autowired
  private BookService bookService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private AuthorService authorService;


  @GetMapping
  public List<BookResponse> getBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping(value = "/{isbn}")
  public BookResponse getBookByIsbn(@PathVariable Long isbn) {
    return bookService.getBookById(isbn);
  }

  @DeleteMapping(value = "/{isbn}")
  public void deleteBook(@PathVariable Long isbn) {
    bookService.deleteBook(isbn);
  }

  @PostMapping
  public BookResponse createOne(@RequestBody BookRequest bookRequest) {
    return bookService.createOne(bookRequest);
  }

  @PutMapping(value = "/{isbn}")
  public void updateBook(@PathVariable Long isbn, @RequestBody Book book) {
    bookService.updateBook(isbn, book);
  }
}
