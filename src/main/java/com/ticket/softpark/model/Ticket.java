package com.ticket.softpark.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name ="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ticket;

    private String prioridade;

    private String descricao;

    private String desenvolvedor;

    private String autor;

    @Enumerated(EnumType.STRING)
    private  Status status;

    private Date prazo;

}
