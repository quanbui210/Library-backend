package com.rest_api.fs14backend.checkout;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CheckoutMapper {

  @Mapping(source = "checkout.book.id", target = "bookId")
  @Mapping(source = "checkout.user.id", target = "userId")
  @Mapping(source = "checkout.book.title", target = "bookName")
  @Mapping(source = "checkout.user.username", target = "username")
  CheckoutResponse toCheckoutResponse(Checkout checkout);

  Checkout toCheckOutEntity(CheckoutRequest checkoutRequest);
}
