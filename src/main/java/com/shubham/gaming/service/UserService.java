package com.shubham.gaming.service;

import com.shubham.gaming.dto.request.CreateUserDto;
import com.shubham.gaming.dto.request.ParticipationDto;
import com.shubham.gaming.dto.response.CreateUserResponseDto;
import com.shubham.gaming.dto.response.GenerateTicketResponseDto;
import com.shubham.gaming.dto.response.GetUserTicketsResponseDto;

public interface UserService {

  CreateUserResponseDto addUser(CreateUserDto userDto);
  GenerateTicketResponseDto generateTicket(Long userId);
  GetUserTicketsResponseDto getTickets(Long userId);
  void participate(ParticipationDto participationDto) throws Exception;
}