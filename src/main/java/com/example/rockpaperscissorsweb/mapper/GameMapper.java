package com.example.rockpaperscissorsweb.mapper;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.GameDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = ScoreMapper.class)
public interface GameMapper {
    @Mapping(target = "lastRound", source = "lastRound")
    @Mapping(target = "score", source = "score")
    @Mapping(target = "maxRound", source = "maxRound")
    public GameDTO toGameDTO(Game game);
}
