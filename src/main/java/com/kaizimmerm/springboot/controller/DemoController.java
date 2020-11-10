package com.kaizimmerm.springboot.controller;

import com.kaizimmerm.springboot.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/hello")
  public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Hello(String.format("Hello %s!", name));
  }
}
