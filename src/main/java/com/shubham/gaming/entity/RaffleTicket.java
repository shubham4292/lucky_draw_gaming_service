package com.shubham.gaming.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tickets")
@Entity
@Data
public class RaffleTicket {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "event_id")
  private Long eventId;
}
