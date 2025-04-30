package com.example.demo.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tournament.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
