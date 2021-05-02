package com.shubham.gaming.dto.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Valid
public class CreateUserDto {
  @NotNull
  private String name;
  @NotNull
  private String email;
  @NotNull
  private String phoneNumber;
}
