package com.ticket.softpark.dto;
import com.ticket.softpark.model.Status;
import com.ticket.softpark.model.Ticket;

public record TicketDetailingDto(

        Long id,
        String ticket,
        String prioridade,
        String descricao,
        String desenvolvedor,
        String autor,
        Status status,
        String prazo
)
{
    public TicketDetailingDto(Ticket ticket) {
        this(
                ticket.getId(),
                ticket.getTicket(),
                ticket.getPrioridade(),
                ticket.getDescricao(),
                ticket.getDesenvolvedor(),
                ticket.getAutor(),
                ticket.getStatus(),
                ticket.getPrazo()
        );
    }
}
