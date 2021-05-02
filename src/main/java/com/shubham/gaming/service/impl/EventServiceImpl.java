package com.shubham.gaming.service.impl;

import com.shubham.gaming.dto.request.CreateEventDto;
import com.shubham.gaming.dto.response.EventResponseDto;
import com.shubham.gaming.dto.response.EventWinnerDto;
import com.shubham.gaming.dto.response.GetUserTicketsResponseDto;
import com.shubham.gaming.dto.response.GetWinnersResponseDto;
import com.shubham.gaming.entity.LuckyDrawEvent;
import com.shubham.gaming.entity.RaffleTicket;
import com.shubham.gaming.enums.EventStatus;
import com.shubham.gaming.repository.LuckyDrawEventRepo;
import com.shubham.gaming.repository.RaffleTicketRepo;
import com.shubham.gaming.repository.UserRepo;
import com.shubham.gaming.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private LuckyDrawEventRepo luckyDrawEventRepo;

  @Autowired
  private RaffleTicketRepo raffleTicketRepo;

  @Autowired
  private UserRepo userRepo;

  @Override
  public EventResponseDto createEvent(CreateEventDto createEventDto){
    EventResponseDto eventResponseDto = new EventResponseDto();
    LuckyDrawEvent luckyDrawEvent = new LuckyDrawEvent();
    BeanUtils.copyProperties(createEventDto, luckyDrawEvent);
    luckyDrawEvent.setStatus(EventStatus.PENDING);
    eventResponseDto.setTicketId(luckyDrawEventRepo.save(luckyDrawEvent).getId());
    return eventResponseDto;
  }

  @Override
  public EventResponseDto getNextEvent(){
    EventResponseDto eventResponseDto = new EventResponseDto();
    eventResponseDto.setTicketId(luckyDrawEventRepo.findNextEvent().getId());
    return eventResponseDto;
  }

  @Override
  public GetWinnersResponseDto getWinners(){
    GetWinnersResponseDto winnersResponseDto = new GetWinnersResponseDto();
    List<EventWinnerDto> eventWinnerDtoList = luckyDrawEventRepo.findLastWeeksWinners().stream().map(event -> {
      EventWinnerDto eventWinnerDto = new EventWinnerDto();
      eventWinnerDto.setEventId(event.getId());
      eventWinnerDto.setUserId(event.getWinner());
      return eventWinnerDto;
    }).collect(Collectors.toList());
    winnersResponseDto.setEventWinnersList(eventWinnerDtoList);
    return winnersResponseDto;
  }

  @Override
  public void calculateWinner(){
    //Get today's event and calculate winner;
    Date todayDate = new Date(Calendar.getInstance().getTime().getTime());
    Optional<LuckyDrawEvent> oTodayEvent = luckyDrawEventRepo.findEventOnDate(todayDate);
    if(!oTodayEvent.isPresent()){
      return;
    }


    LuckyDrawEvent todayEvent = oTodayEvent.get();

    RaffleTicket winnerTicket = raffleTicketRepo.getWinnerTicket(todayEvent.getId());
    todayEvent.setWinner(winnerTicket.getUserId());
    todayEvent.setStatus(EventStatus.COMPLETED);
    //announce winner
    luckyDrawEventRepo.save(todayEvent);
  }

}
