package com.example.rockpaperscissorsweb.controller;

import com.example.rockpaperscissorsweb.ConfigService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
@Import(ConfigService.class)
@AutoConfigureMockMvc
class GameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void startNewGame() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/start")
        ).andExpect(status().isOk());
    }

    @Test
    void nextRound() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/start")
        ).andExpect(status().isOk());
        mvc.perform(
                MockMvcRequestBuilders.get("/nextRound").param("choice", "ROCK")
        ).andExpect(status().isOk());
    }

    @Test
    void finishGame() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/start")
        ).andExpect(status().isOk());
        mvc.perform(
                MockMvcRequestBuilders.get("/finish")
        ).andExpect(status().isOk());
    }
}