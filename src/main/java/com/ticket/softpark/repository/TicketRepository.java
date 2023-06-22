package com.ticket.softpark.repository;
import com.ticket.softpark.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findByTicket(String ticket);
}
