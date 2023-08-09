package com.alvestech.gamespage.repositories;

import com.alvestech.gamespage.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}