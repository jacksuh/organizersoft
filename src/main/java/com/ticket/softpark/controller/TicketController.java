package com.ticket.softpark.controller;

import com.ticket.softpark.dto.TicketDetailingDto;
import com.ticket.softpark.dto.TicketDto;
import com.ticket.softpark.model.Ticket;
import com.ticket.softpark.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("ticket")
public class TicketController {


    @Autowired
    private TicketService service;

    public ResponseEntity books(@RequestBody TicketDto dto, UriComponentsBuilder uriBuilder){
        Ticket t = service.saveTicket(dto);
        var uri = uriBuilder.path("/ticket/{id}").buildAndExpand(t.getTicket()).toUri();
        return ResponseEntity.created(uri).body(new TicketDetailingDto((Ticket) t));
    }


}
