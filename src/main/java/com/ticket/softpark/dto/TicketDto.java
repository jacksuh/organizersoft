package com.ticket.softpark.dto;

import com.ticket.softpark.model.Status;

public record TicketDto(
        String ticket,
        String prioridade,
        String descricao,
        String desenvolvedor,
        String autor,
        Status status,
        String prazo
) {
}
