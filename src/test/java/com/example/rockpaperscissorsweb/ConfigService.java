package com.example.rockpaperscissorsweb;

import com.example.rockpaperscissorsweb.mapper.GameMapper;
import com.example.rockpaperscissorsweb.mapper.GameMapperImpl;
import com.example.rockpaperscissorsweb.mapper.ScoreMapper;
import com.example.rockpaperscissorsweb.mapper.ScoreMapperImpl;
import com.example.rockpaperscissorsweb.service.GameService;
import org.springframework.context.annotation.Bean;

public class ConfigService {

    @Bean
    public GameService gameService() {
        return new GameService();
    }

    @Bean
    public ScoreMapper scoreMapper() {
        return new ScoreMapperImpl();
    }

    @Bean
    public GameMapper gameMapper() {
        return new GameMapperImpl(new ScoreMapperImpl());
    }
}
