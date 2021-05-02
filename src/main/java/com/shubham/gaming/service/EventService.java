package com.shubham.gaming.service;

import com.shubham.gaming.dto.request.CreateEventDto;
import com.shubham.gaming.dto.response.EventResponseDto;
import com.shubham.gaming.dto.response.GetWinnersResponseDto;

public interface EventService {

  EventResponseDto createEvent(CreateEventDto createEventDto);
  EventResponseDto getNextEvent();
  GetWinnersResponseDto getWinners();
  void calculateWinner();

}