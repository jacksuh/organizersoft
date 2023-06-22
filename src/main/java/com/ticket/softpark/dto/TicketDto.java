package com.ticket.softpark.dto;

public record TicketDto(
        String ticket,
        String prioridade,
        String descricao,
        String desenvolvedor,
        String autor,
        String status,
        String prazo
) {
}
