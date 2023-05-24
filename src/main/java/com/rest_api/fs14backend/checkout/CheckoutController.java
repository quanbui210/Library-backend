package com.rest_api.fs14backend.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CheckoutController {
  @Autowired
  private CheckoutService checkoutService;
  @PostMapping("/checkout")
  public CheckoutResponse borrowOne(@RequestBody CheckoutRequest checkoutRequest) {
    return checkoutService.borrowOne(checkoutRequest);
  }
  @PostMapping("/return")
  public CheckoutResponse returnOne(@RequestBody CheckoutResponse checkoutResponse) {
    return checkoutService.returnOne(checkoutResponse);
  }
}
