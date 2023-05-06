package com.rest_api.fs14backend.book;

import com.rest_api.fs14backend.author.Author;
import com.rest_api.fs14backend.author.AuthorService;
import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
  private final BookService bookService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private AuthorService authorService;

  @Autowired
  private BookMapper bookMapper;

  public BookController( BookService bookService) {
    this.bookService = bookService;
  }


  @GetMapping
  public List<Book> getBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping(value = "/{isbn}")
  public Optional<Book> getBookByIsbn(@PathVariable Long isbn) {
    return bookService.getBookById(isbn);
  }

  @DeleteMapping(value = "/{isbn}")
  public void deleteBook(@PathVariable Long isbn) {
    bookService.deleteBook(isbn);
  }
  @PostMapping("/")
  public Book createOne(@RequestBody BookDTO bookDTO) {
    UUID categoryId = bookDTO.getCategoryId();
    Category category = categoryService.findById(categoryId);
    UUID authorId = bookDTO.getAuthorId();
    Author author;
    if (authorId == null) { // If authorId is not provided in the request, create a new author
      author = new Author(bookDTO.getAuthorName(), bookDTO.getAuthorDob(), bookDTO.getAuthorDescription());
      authorService.AddAuthor(author);
    } else {
      author = authorService.getAuthorById(authorId);
    }
    Book book = bookMapper.newBook(bookDTO, category, author);
    return bookService.createOne(book);
  }
  @PostMapping
  public void createOne(@RequestBody Book book) {
    bookService.addOneBook(book);
  }
  @PutMapping(value = "/{isbn}")
  public void updateBook(@PathVariable Long isbn, @RequestBody Book book) {
    bookService.updateBook(isbn, book);
  }
}
