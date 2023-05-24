package com.rest_api.fs14backend.checkout;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CheckoutMapper {

  @Mapping(source = "book.id", target = "bookId")
  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "book.title", target = "bookName")
  @Mapping(source = "user.username", target = "username")
  CheckoutResponse toCheckoutResponse(Checkout checkout);

  Checkout toCheckOutEntity(CheckoutRequest checkoutRequest);
}
