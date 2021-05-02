package com.shubham.gaming.service.impl;

import com.shubham.gaming.dto.request.CreateUserDto;
import com.shubham.gaming.dto.request.ParticipationDto;
import com.shubham.gaming.dto.response.CreateUserResponseDto;
import com.shubham.gaming.dto.response.GenerateTicketResponseDto;
import com.shubham.gaming.dto.response.GetUserTicketsResponseDto;
import com.shubham.gaming.entity.LuckyDrawEvent;
import com.shubham.gaming.entity.RaffleTicket;
import com.shubham.gaming.entity.User;
import com.shubham.gaming.repository.LuckyDrawEventRepo;
import com.shubham.gaming.repository.RaffleTicketRepo;
import com.shubham.gaming.repository.UserRepo;
import com.shubham.gaming.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


  @Autowired
  private LuckyDrawEventRepo luckyDrawEventRepo;

  @Autowired
  private RaffleTicketRepo raffleTicketRepo;

  @Autowired
  private UserRepo userRepo;

  @Override
  public CreateUserResponseDto addUser(CreateUserDto userDto){
    CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    user = userRepo.save(user);
    createUserResponseDto.setUserId(user.getId());
    return createUserResponseDto;
  }

  @Override
  public GenerateTicketResponseDto generateTicket(Long userId){
    GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
    RaffleTicket newTicket = new RaffleTicket();
    String ticketId = UUID.randomUUID().toString();
    newTicket.setId(ticketId);
    newTicket.setUserId(userId);
    raffleTicketRepo.save(newTicket);
    responseDto.setTicketId(ticketId);
    return responseDto;
  }

  @Override
  public GetUserTicketsResponseDto getTickets(Long userId){
    //returns unused tickets
    GetUserTicketsResponseDto responseDto = new GetUserTicketsResponseDto();
    responseDto.setTicketIds(raffleTicketRepo.findByUserIdAndEventId(userId, null).stream().map(
        ticket -> ticket.getId()).collect(Collectors.toList()));
    return responseDto;
  }

  @Override
  public void participate(ParticipationDto participationDto) throws Exception{
    Optional<RaffleTicket> oParticipationTicket = raffleTicketRepo.findById(participationDto.getTicketId());
    Optional<LuckyDrawEvent> optionalLuckyDrawEvent = luckyDrawEventRepo.findById(participationDto.getEventId());
    if(!oParticipationTicket.isPresent() || !optionalLuckyDrawEvent.isPresent()){
      throw new Exception("ticket id or event not present");
    }
    RaffleTicket raffleTicket = oParticipationTicket.get();
    raffleTicket.setEventId(participationDto.getEventId());
    raffleTicketRepo.save(raffleTicket);
  }

}
