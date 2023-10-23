package com.alvestech.gamespage.controllers;

import com.alvestech.gamespage.dto.GameMinDTO;
import com.alvestech.gamespage.dto.ListaJogosDTO;
import com.alvestech.gamespage.dto.ReplacementDTO;
import com.alvestech.gamespage.servicies.GameService;
import com.alvestech.gamespage.servicies.ListaJogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListaJogosController {
    @Autowired
    private ListaJogosService listaJogosService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<ListaJogosDTO> findAll(){
        List<ListaJogosDTO> result = listaJogosService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        listaJogosService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}