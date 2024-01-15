package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateFootballTeamRequest;
import tn.iit.response.FootballTeamResponse;
import tn.iit.service.FootballTeamService;

import java.util.List;

@RestController
@RequestMapping("/api/footballteam")
public class FootballTeamController {

    @Autowired
    private FootballTeamService footballTeamService;

    @PostMapping("")
    public FootballTeamResponse createFootballTeam(@RequestBody CreateFootballTeamRequest createFootballTeamRequest) {
        return footballTeamService.createFootballTeam(createFootballTeamRequest);
    }

    @GetMapping("")
    public List<FootballTeamResponse> getAllFootballTeams() {
        return footballTeamService.getAllFootballTeams();
    }

    @GetMapping("/{id}")
    public FootballTeamResponse getFootballTeamById(@PathVariable Long id) {
        return footballTeamService.getFootballTeamById(id);
    }


    @DeleteMapping("/{id}")
    public List<FootballTeamResponse> deleteFootballTeam(@PathVariable Long id) {
        return footballTeamService.deleteFootballTeam(id);
    }

    @PutMapping("/{id}/coach")
    public FootballTeamResponse updateFootballTeamCoach(@PathVariable Long id, @RequestBody Long coachId) {
        return footballTeamService.updateFootballTeamCoach(id, coachId);
    }

    @DeleteMapping("/{id}/coach")
    public FootballTeamResponse removeFootballTeamCoach(@PathVariable Long id) {
        return footballTeamService.removeFootballTeamCoach(id);
    }

    @PutMapping("/{id}/stadium")
    public FootballTeamResponse updateFootballTeamStadium(@PathVariable Long id, @RequestBody Long stadiumId) {
        return footballTeamService.updateFootballTeamStadium(id, stadiumId);
    }

    @DeleteMapping("/{id}/stadium")
    public FootballTeamResponse removeFootballTeamStadium(@PathVariable Long id) {
        return footballTeamService.removeFootballTeamStadium(id);
    }

    @PutMapping("/{id}/players")
    public FootballTeamResponse addPlayerToFootballTeam(@PathVariable Long id, @RequestBody Long playerId) {
        return footballTeamService.addPlayerToFootballTeam(id, playerId);
    }

    @DeleteMapping("/{id}/players")
    public FootballTeamResponse removePlayerFromFootballTeam(@PathVariable Long id, @RequestBody Long playerId) {
        return footballTeamService.removePlayerFromFootballTeam(id, playerId);
    }
}
