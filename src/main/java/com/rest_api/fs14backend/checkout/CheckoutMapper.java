package com.rest_api.fs14backend.checkout;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CheckoutMapper {
  @Mapping(source = "id", target = "bookId")
  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "book.title", target = "bookName")
  @Mapping(source = "user.username", target = "username")
  CheckoutResponse toCheckoutResponse(Checkout checkout);


  @Mapping(source = "id", target = "bookId")
  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "book.title", target = "bookName")
  @Mapping(source = "user.username", target = "username")
  List<CheckoutResponse> toListCheckoutResponse(List<Checkout> checkoutList);

  @Mapping(source = "bookId", target = "book.id")
  @Mapping(source = "userId", target = "user.id")
  @Mapping(target = "borrowedDate", ignore = true)
  @Mapping(target = "returnedDate", ignore = true)
  @Mapping(target = "returned", ignore = true)
  Checkout toCheckOutEntity(CheckoutRequest checkoutRequest);
}
