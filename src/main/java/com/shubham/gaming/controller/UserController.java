package com.shubham.gaming.controller;

import com.shubham.gaming.dto.request.CreateUserDto;
import com.shubham.gaming.dto.request.ParticipationDto;
import com.shubham.gaming.dto.response.CreateUserResponseDto;
import com.shubham.gaming.dto.response.GenerateTicketResponseDto;
import com.shubham.gaming.dto.response.GetUserTicketsResponseDto;
import com.shubham.gaming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/addUser")
  public ResponseEntity<CreateUserResponseDto> addUser(@Valid @RequestBody CreateUserDto userDto) {

    return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
  }

  @PostMapping(value = "/generateTicket")
  public ResponseEntity<GenerateTicketResponseDto> generateTicket(@RequestParam Long userId){
    return new ResponseEntity<>(userService.generateTicket(userId), HttpStatus.CREATED);
  }

  @GetMapping(value = "/getTickets")
  public ResponseEntity<GetUserTicketsResponseDto> getTickets(@RequestParam Long userId){
    return new ResponseEntity<>(userService.getTickets(userId), HttpStatus.OK);
  }

  @PostMapping(value = "/participate")
  public ResponseEntity<String> participate(@Valid @RequestBody ParticipationDto participationDto) throws Exception{
    userService.participate(participationDto);
    return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
  }
}
