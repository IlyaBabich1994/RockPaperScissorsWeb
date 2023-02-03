package com.example.rockpaperscissorsweb.mapper;

import com.example.rockpaperscissorsweb.model.Score;
import com.example.rockpaperscissorsweb.model.ScoreDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ScoreMapper {
    @Mapping(target = "scoreComp", source = "scoreComp")
    @Mapping(target = "tie", source = "tie")
    @Mapping(target = "scorePlayer", source = "scorePlayer")
    ScoreDTO toScoreDTO(Score score);
}
