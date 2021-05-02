package com.shubham.gaming.dto.response;

import lombok.Data;

import java.security.PrivateKey;
import java.util.List;

@Data
public class GetWinnersResponseDto {

  private List<EventWinnerDto> eventWinnersList;
}
