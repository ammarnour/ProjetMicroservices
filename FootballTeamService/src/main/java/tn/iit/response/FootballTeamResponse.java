package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Coach;
import tn.iit.entity.Player;
import tn.iit.entity.Stadium;
import tn.iit.entity.FootballTeam;

import java.util.List;

@Setter
@Getter
public class FootballTeamResponse {

    private Long id;
    private String name;
    private Stadium stadium;
    private Coach coach;  
    private List<Player> players;

    public FootballTeamResponse(FootballTeam footballTeam) {
        this.id = footballTeam.getId();
        this.name = footballTeam.getName();
        this.stadium = footballTeam.getStadium();
        this.coach = footballTeam.getCoach();  
        this.players = footballTeam.getPlayers();
    }
}
