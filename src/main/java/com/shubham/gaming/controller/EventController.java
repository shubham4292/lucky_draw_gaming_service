package com.shubham.gaming.controller;

import com.shubham.gaming.dto.request.CreateEventDto;
import com.shubham.gaming.dto.response.EventResponseDto;
import com.shubham.gaming.dto.response.GetWinnersResponseDto;
import com.shubham.gaming.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EventController {

  @Autowired
  private EventService eventService;

  @PostMapping(value = "/createEvent")
  private ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody CreateEventDto createEventDto){
    return new ResponseEntity<>(eventService.createEvent(createEventDto), HttpStatus.CREATED);
  }

  @GetMapping(value = "/getNextEvent")
  private ResponseEntity<EventResponseDto> getNextEvent(){
    return new ResponseEntity<>(eventService.getNextEvent(), HttpStatus.OK);
  }

  @GetMapping(value = "/getWinners")
  private ResponseEntity<GetWinnersResponseDto> getWinners(){
    return new ResponseEntity<>(eventService.getWinners(), HttpStatus.OK);
  }
}
