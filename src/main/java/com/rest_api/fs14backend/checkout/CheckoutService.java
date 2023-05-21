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
    if (book.getQuantity() > 0) {
      book.setQuantity(book.getQuantity() - 1);
      checkout.setBook(book);
      checkout.setUser(user);
      checkout.setBorrowedDate(LocalDate.now());
      checkoutResponse = checkoutMapper.toCheckoutResponse(checkout);

      List<Checkout> checkoutList = user.getCheckoutList();
      checkoutList.add(checkout);
      user.setCheckoutList(checkoutList);
      checkoutRepository.save(checkout);
    }
    return checkoutResponse;
  }
//  public CheckoutResponse returnOne (CheckoutRequest checkoutRequest) {
//    Book book = bookRepository.findBookById(checkoutRequest.getBookId());
//    User user = userRepository.findUserById(checkoutRequest.getUserId());
//    Checkout checkout = checkoutRepository.findCheckout(book, user);
//
//    checkout.setReturned(true);
//    checkout.setReturnedDate(LocalDate.now());
//    book.setQuantity(book.getQuantity() + 1);
//    checkoutRepository.save(checkout);
//    bookRepository.save(book);
//
//    return checkoutMapper.toCheckoutResponse(checkout);
//  }
}
