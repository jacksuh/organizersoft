package com.ticket.softpark.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest
@AutoConfigureMockMvc
class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void salvarTicket() {
    }

    @Test
    void pegarTickets() throws Exception {
            var response = mvc
                    .perform(get("/ticket")
                    )
                    .andReturn().getResponse();

            assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        }

    @Test
    void atualizarTickets() {
    }

    @Test
    void deletarTicket() {
    }
}