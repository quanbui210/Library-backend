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
 @Autowired
  private BookMapper bookMapper;

  public List<BookResponse> getAllBooks() {
    List<Book> bookList = bookRepository.findAll();
    List<BookResponse> bookResponseList = bookMapper.toListBookResponse(bookList);
    return bookResponseList;
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
    bookRepository.save(book);
    return bookMapper.toBookResponse(book);
  }

  public BookResponse getBookById(Long isbn) {
    Book book = bookRepository.findBookByISBN(isbn);
    BookResponse bookResponse = bookMapper.toBookResponse(book);
    return bookResponse;
  }

  public void deleteBook(Long isbn) {
    Book bookToDelete = bookRepository.findBookByISBN(isbn);
    bookRepository.delete(bookToDelete);
  }

  @Transactional
  public BookResponse updateBook(Long isbn, BookRequest bookRequest) {
    Author author = authorRepository.findAuthorById(bookRequest.getAuthorId());
    Category category = categoryRepository.findById(bookRequest.getCategoryId()).get();
    Book bookToEdit = bookRepository.findBookByISBN(isbn);
    bookToEdit.setAuthor(author);
    bookToEdit.setTitle(bookRequest.getTitle());
    bookToEdit.setCategory(category);
    bookToEdit.setDescription(bookRequest.getDescription());
    bookToEdit.setISBN(bookRequest.getISBN());
    bookToEdit.setPublishedDate(bookRequest.getPublishedDate());
    bookToEdit.setStatus(bookRequest.getStatus());
    bookToEdit.setPublishers(bookRequest.getPublishers());
    BookResponse bookResponse = bookMapper.toBookResponse(bookToEdit);
    return bookResponse;
  }
}
