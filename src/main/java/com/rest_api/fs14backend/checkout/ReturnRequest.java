package com.rest_api.fs14backend.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ReturnRequest {
  private UUID checkoutId;
}
