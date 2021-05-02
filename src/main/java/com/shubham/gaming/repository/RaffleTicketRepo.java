package com.shubham.gaming.repository;

import com.shubham.gaming.entity.RaffleTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaffleTicketRepo extends CrudRepository<RaffleTicket, String> {

  List<RaffleTicket> findByUserIdAndEventId(Long userId, Long eventId);
}
