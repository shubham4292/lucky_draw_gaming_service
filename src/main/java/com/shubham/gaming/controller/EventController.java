package com.shubham.gaming.controller;

import com.shubham.gaming.service.ThirdPartyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class EventController {

  @Autowired
  private ThirdPartyApiService thirdPartyApiService;

  @GetMapping(value = "/createEvent")
  private ResponseEntity<String> createEvent() throws IOException, GeneralSecurityException {
    thirdPartyApiService.fetchAndUpdateSheet();
    return new ResponseEntity<>("Hello", HttpStatus.CREATED);
  }

}
