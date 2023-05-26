package com.rest_api.fs14backend.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CheckoutController {
  @Autowired
  private CheckoutService checkoutService;

  @PostMapping("/checkout")
  public CheckoutResponse borrowOne(@RequestBody CheckoutRequest checkoutRequest) {
    return checkoutService.borrowOne(checkoutRequest);
  }

  @GetMapping("/checkouts")
  public List<CheckoutResponse> getAllCheckouts() {
    return checkoutService.getCheckouts();
  }

  @PostMapping("/return")
  public CheckoutResponse returnOne(@RequestBody ReturnRequest returnRequest) {
    return checkoutService.returnOne(returnRequest);
  }
}
