package com.example.demo.Controller.tournament;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.tournament.Goal;
import com.example.demo.entity.tournament.Match;
import com.example.demo.entity.tournament.Player;
import com.example.demo.repository.tournament.GoalRepository;
import com.example.demo.repository.tournament.MatchRepository;
import com.example.demo.repository.tournament.PlayerRepository;

@Controller
@RequestMapping("/tournaments/{tournamentId}/matches/{matchId}")
public class GoalController {

    private final MatchRepository matchRepository;
    private final GoalRepository goalRepository;
    private final PlayerRepository playerRepository;

    
    public GoalController(MatchRepository matchRepository, GoalRepository goalRepository,
			PlayerRepository playerRepository) {
		this.matchRepository = matchRepository;
		this.goalRepository = goalRepository;
		this.playerRepository = playerRepository;
	}

	@GetMapping
    public String showGoalForm(@PathVariable Long tournamentId,
                               @PathVariable Long matchId,
                               Model model) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        System.out.println();
        model.addAttribute("match", match);
        model.addAttribute("goal", new Goal());
        return "goal"; // Create this HTML file
    }

    @PostMapping
    public String addGoal(@PathVariable Long tournamentId,
                          @PathVariable Long matchId,
                          @ModelAttribute Goal goal) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        goal.setMatch(match);
        goalRepository.save(goal);
        
        Player player = playerRepository.findById(goal.getPlayer().getId()).orElseThrow();
        goal.setPlayer(player);
        
        System.out.println(tournamentId+" "+matchId);
        return "redirect:/tournaments/" + tournamentId + "/matches/" + matchId;
    }
    
 
}
