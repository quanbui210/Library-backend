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
  @Autowired
  private BookService bookService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private AuthorService authorService;

  @Autowired
  private BookMapper bookMapper;


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
  @PostMapping
  public Book createOne(@RequestBody BookDTO bookDTO) {
    UUID categoryId = bookDTO.getCategoryId();
    UUID authorId = bookDTO.getAuthorId();
    Author author;
    Category category;
    if (authorId == null) { // If authorId is not provided in the request, create a new author
      author = new Author(bookDTO.getAuthorName(), bookDTO.getAuthorDescription());
      authorService.addAuthor(author);
    } else {
      author = authorService.getAuthorById(authorId);
    }
    if (categoryId == null) {
      category = new Category(bookDTO.getCategoryName());
      categoryService.createOne(category);
    } else {
      category = categoryService.findById(categoryId);
    }
    Book book = new Book(
            bookDTO.getISBN(),
            bookDTO.getTitle(),
            bookDTO.getPublishedDate(),
            bookDTO.getDescription(),
            Book.Status.AVAILABLE,
            bookDTO.getPublishers(),
            category,
            authorId != null ? author : null
    );
    return bookService.createOne(book);
  }
  @PutMapping(value = "/{isbn}")
  public void updateBook(@PathVariable Long isbn, @RequestBody Book book) {
    bookService.updateBook(isbn, book);
  }
}
