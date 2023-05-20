package com.rest_api.fs14backend.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
public class CheckoutRequest {
  private UUID bookId;
  private UUID userId;
  private LocalDate borrowedDate;
}
