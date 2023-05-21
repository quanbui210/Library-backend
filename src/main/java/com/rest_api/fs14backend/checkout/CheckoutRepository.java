package com.rest_api.fs14backend.checkout;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
  public Checkout findCheckoutById(UUID id);

//  public Checkout findCheckout(Book book, User user);
}
