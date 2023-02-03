package com.example.rockpaperscissorsweb.controller;

import com.example.rockpaperscissorsweb.mapper.GameMapper;
import com.example.rockpaperscissorsweb.mapper.ScoreMapper;
import com.example.rockpaperscissorsweb.model.GameDTO;
import com.example.rockpaperscissorsweb.model.ScoreDTO;
import com.example.rockpaperscissorsweb.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;
    private final ScoreMapper scoreMapper;

    public GameController(GameService gameService, GameMapper gameMapper, ScoreMapper scoreMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
        this.scoreMapper = scoreMapper;
    }

    @GetMapping("/start")
    public ResponseEntity<GameDTO> startNewGame(){
        GameDTO gameDTO = gameMapper.toGameDTO(gameService.startNewGame());
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @GetMapping("/nextRound")
    public ResponseEntity<GameDTO> nextRound(@RequestParam String choice){
        GameDTO gameDTO = gameMapper.toGameDTO(gameService.playRound(choice));
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @GetMapping("/finish")
    public ResponseEntity<ScoreDTO> finishGame(){
        ScoreDTO scoreDTO = scoreMapper.toScoreDTO(gameService.finishGame());
        return new ResponseEntity<>(scoreDTO, HttpStatus.OK);
    }

}
