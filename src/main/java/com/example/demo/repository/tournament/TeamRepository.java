package com.example.demo.repository.tournament;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tournament.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	Optional<Team> findByName(String name);
}
