package com.example.demo.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tournament.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
