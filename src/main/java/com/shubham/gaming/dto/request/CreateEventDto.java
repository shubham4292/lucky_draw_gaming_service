package com.shubham.gaming.dto.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateEventDto {

  @NotNull
  private Date date;

  @NotNull
  private String prize;
}
