package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private int callCount = 0;

  @GetMapping("/hello/callCount")
  public String getCallCount() {
    callCount++;
    return "Endpoint /hello wurde " + callCount + " mal aufgerufen.";
  }

  @GetMapping("/hello")
  public RandomUser getRandomUser() {
    RandomUser randomUser = new RandomUser();
    randomUser.setHello(1); // Zufällige Zahl zwischen 0 und 99
    randomUser.setWorld("world");
    return randomUser;
  }
}
