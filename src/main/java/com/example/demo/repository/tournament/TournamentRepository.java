package com.example.demo.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tournament.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
