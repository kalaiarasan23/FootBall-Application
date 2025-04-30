package com.example.demo.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tournament.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
