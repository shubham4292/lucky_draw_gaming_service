package com.shubham.gaming.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ParticipationDto {

  @NotNull
  private String ticketId;

  @NotNull
  private Long eventId;

}
