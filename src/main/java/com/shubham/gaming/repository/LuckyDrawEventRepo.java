package com.shubham.gaming.repository;

import com.shubham.gaming.entity.LuckyDrawEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LuckyDrawEventRepo extends CrudRepository<LuckyDrawEvent, Long> {

  @Query(value = "SELECT * FROM events order by date asc 0,1")
  LuckyDrawEvent findNextEvent();

  @Query(value = "SELECT * FROM events WHERE status = 'COMPLETED' order by date desc 0,7")
  List<LuckyDrawEvent> findLastWeeksWinners();

  @Query(value = "SELECT * FROM events WHERE date = :date")
  Optional<LuckyDrawEvent> findEventOnDate(Date date);
}
