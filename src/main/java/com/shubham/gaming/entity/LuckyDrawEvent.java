package com.shubham.gaming.entity;

import com.shubham.gaming.enums.EventStatus;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "events")
@Entity
@Data
public class LuckyDrawEvent {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  @Column(name = "id")
  private Long id;

  @Column(name = "date")
  private Date date;

  @Column(name = "prize")
  private String prize;

  @Column(name = "winner_id")
  private Long winner;

  @Column(name = "status")
  private EventStatus status;
}
