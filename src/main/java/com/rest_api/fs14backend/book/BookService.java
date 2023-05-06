package com.rest_api.fs14backend.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
  public void addOneBook(Book book) {
    bookRepository.save(book);
  }

  public Book createOne(Book book) {
    return bookRepository.save(book);
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
    }
  }
}
