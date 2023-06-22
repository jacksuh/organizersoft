package com.ticket.softpark.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name ="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String ticket;

    String prioridade;

    String descricao;

    String desenvolvedor;

    String autor;

    String status;

    String prazo;

}
