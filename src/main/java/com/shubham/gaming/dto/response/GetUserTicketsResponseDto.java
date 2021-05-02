package com.shubham.gaming.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GetUserTicketsResponseDto {

  private List<String> ticketIds;
}
