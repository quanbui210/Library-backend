package com.rest_api.fs14backend.checkout;

import com.rest_api.fs14backend.book.Book;
import com.rest_api.fs14backend.book.BookRepository;
import com.rest_api.fs14backend.user.User;
import com.rest_api.fs14backend.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutService {
  @Autowired
  private CheckoutRepository checkoutRepository;
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CheckoutMapper checkoutMapper;
  @Autowired
  private CheckoutResponse checkoutResponse;


  public CheckoutResponse borrowOne(CheckoutRequest checkoutRequest) {
    Book book = bookRepository.findBookById(checkoutRequest.getBookId());
    User user = userRepository.findUserById(checkoutRequest.getUserId());
    Checkout checkout = checkoutMapper.toCheckOutEntity(checkoutRequest);

    checkout.setBook(book);
    checkout.setUser(user);
    checkout.setBorrowedDate(LocalDate.now());

    book.setStatus(Book.Status.BORROWED);
    bookRepository.save(book);

    checkoutRepository.save(checkout);
    checkoutResponse = checkoutMapper.toCheckoutResponse(checkout);

    List<Checkout> checkoutList = user.getCheckoutList();
    checkoutList.add(checkout);
    user.setCheckoutList(checkoutList);

    return checkoutResponse;
  }

  public CheckoutResponse returnOne(ReturnRequest returnRequest) {
    Checkout checkout = checkoutRepository.findCheckoutById(returnRequest.getCheckoutId());
    Book book = checkout.getBook();
    book.setStatus(Book.Status.AVAILABLE);
    checkout.setReturned(true);
    checkout.setReturnedDate(LocalDate.now());
    checkoutRepository.save(checkout);
    return checkoutMapper.toCheckoutResponse(checkout);
  }

  public List<CheckoutResponse> getCheckouts() {
    List<Checkout> checkoutList = checkoutRepository.findAll();
    List<CheckoutResponse> checkoutResponseList = checkoutMapper.toListCheckoutResponse(checkoutList);
    return checkoutResponseList;
  }
}
