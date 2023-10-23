package com.alvestech.gamespage.servicies;

import com.alvestech.gamespage.dto.ListaJogosDTO;
import com.alvestech.gamespage.entities.ListaJogos;
import com.alvestech.gamespage.projections.GameMinProjection;
import com.alvestech.gamespage.repositories.GameRepository;
import com.alvestech.gamespage.repositories.ListaJogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListaJogosService {
    @Autowired
    private ListaJogosRepository listaJogosRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<ListaJogosDTO> findAll() {
        List<ListaJogos> result = listaJogosRepository.findAll();
        return result.stream().map(ListaJogosDTO::new).toList();
    }

    @Transactional
    public void move (Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = min; i <= max; i++){
            listaJogosRepository.updateBelongingPosition(listId , list.get(i).getId(), i);
        }
    }
}