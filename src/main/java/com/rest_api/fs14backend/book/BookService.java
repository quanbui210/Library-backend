package com.rest_api.fs14backend.book;

import com.rest_api.fs14backend.author.Author;
import com.rest_api.fs14backend.author.AuthorRepository;
import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BookService {
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  private BookMapper bookMapper;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
  public void addOneBook(Book book) {
    bookRepository.save(book);
  }

  public BookResponse createOne(BookRequest bookRequest) {
    Author author = authorRepository.findAuthorById(bookRequest.getAuthorId());
    Category category = categoryRepository.findById(bookRequest.getCategoryId()).get();
    Book book = bookMapper.toBookEntity(bookRequest);
    book.setCategory(category);
    book.setAuthor(author);
    return bookMapper.toBookResponse(book);
  }

  public Optional<Book> getBookById(Long isbn) {
    return bookRepository.findBookByISBN(isbn);
  }

  public void deleteBook(Long isbn) {
    Optional<Book> bookToDelete = bookRepository.findBookByISBN(isbn);
    if (bookToDelete.isPresent()) {
      bookRepository.delete(bookToDelete.get());
    } else {
      throw new IllegalStateException("Book with " + isbn + " not found");
    }
  }

  @Transactional
  public void updateBook(Long isbn, Book newBook) {
    Optional<Book> bookToEdit = bookRepository.findBookByISBN(isbn);
    if (bookToEdit.isPresent()) {
      bookToEdit.get().setDescription(newBook.getDescription());
      bookToEdit.get().setTitle(newBook.getTitle());
      bookToEdit.get().setPublishers(newBook.getPublishers());
      bookToEdit.get().setAuthor(newBook.getAuthor());
      bookToEdit.get().setCategory(newBook.getCategory());
    }
  }
}
