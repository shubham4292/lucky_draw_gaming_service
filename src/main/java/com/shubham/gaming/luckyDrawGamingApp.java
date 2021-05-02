package com.shubham.gaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class luckyDrawGamingApp {

  public static void main(String[] args) {
    SpringApplication.run(luckyDrawGamingApp.class, args);
  }
}
