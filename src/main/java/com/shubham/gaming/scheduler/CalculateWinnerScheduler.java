package com.shubham.gaming.scheduler;

import com.shubham.gaming.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CalculateWinnerScheduler {

  @Autowired
  private EventService eventService;

  //Event runs every morning 8 AM
  @Scheduled(cron = "0 0 8 * * *")
  public void runEventScheduler(){
    eventService.calculateWinner();
  }
}
