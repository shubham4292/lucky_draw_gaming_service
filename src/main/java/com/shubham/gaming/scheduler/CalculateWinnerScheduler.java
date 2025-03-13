package com.shubham.gaming.scheduler;

import com.shubham.gaming.service.ThirdPartyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
public class CalculateWinnerScheduler {

  @Autowired
  private ThirdPartyApiService thirdPartyApiService;

  @Scheduled(cron = "0/10 * * ? * *")
  public void runEventScheduler() throws IOException, GeneralSecurityException {
    thirdPartyApiService.fetchAndUpdateSheet();
  }
}
