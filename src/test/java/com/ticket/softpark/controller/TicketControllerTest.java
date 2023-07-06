package com.ticket.softpark.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
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
    void salvarTicket() throws Exception{

        String json = "{\"nome\":\"Jackson\",\"ticket\":\"82\",\"altura\":\"1.78\"}";

        var response = mvc.perform(
                        post("/ticket")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

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
    void atualizarTickets() throws Exception {

        String json = "{\"nome\":\"Jackson\",\"pesoAtual\":\"82\",\"altura\":\"82\"}";

        var response = mvc.perform(
                        put("/ticket/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());



    }

    @Test
    void deletarTicket() throws Exception{

        var response = mvc
                .perform(delete("/ticket/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
}