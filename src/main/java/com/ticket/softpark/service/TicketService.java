package com.ticket.softpark.service;
import com.ticket.softpark.dto.TicketDto;
import com.ticket.softpark.exception.ValidationException;
import com.ticket.softpark.model.Ticket;
import com.ticket.softpark.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;


    public Page<Ticket> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public Ticket saveTicket(TicketDto dto) {
        Optional<Ticket> ticket = Optional.ofNullable(repository.findByTicket(dto.ticket()));

        if(ticket.isPresent()){
            throw new ValidationException("Ticket Já existe!");
        }else {
            Ticket t = new Ticket();
            t.setAutor(dto.autor());
            t.setTicket(dto.ticket());
            t.setDescricao(dto.descricao());
            t.setPrazo(dto.prazo());
            t.setDesenvolvedor(dto.desenvolvedor());
            t.setStatus(dto.status());
            t.setPrioridade(dto.prioridade());


            Ticket savedticket = repository.save(t);

            return savedticket;
        }
    }
        public Ticket updateTicket(TicketDto dto, Long id) {
            Optional<Ticket> optional = repository.findById(id);
            Ticket tk = optional.get();
            tk.setTicket(dto.ticket());
            tk.setAutor(dto.autor());
            tk.setPrazo(dto.prazo());
            tk.setDescricao(dto.descricao());
            tk.setDesenvolvedor(dto.desenvolvedor());
            tk.setPrioridade(dto.prioridade());
            tk.setStatus(dto.status());

            return repository.save(tk);
        }


    public void deleteTicket(Long id) {
        Optional<Ticket> tk = repository.findById(id);
        if (tk.isPresent()) {
            repository.deleteById(id);
        }

    }
}
