package com.rest_api.fs14backend.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/checkout")
public class CheckoutController {
  @Autowired
  private CheckoutService checkoutService;

  @PostMapping
  public CheckoutResponse borrowOne(@RequestBody CheckoutRequest checkoutRequest) {
    return checkoutService.borrowOne(checkoutRequest);
  }
}
