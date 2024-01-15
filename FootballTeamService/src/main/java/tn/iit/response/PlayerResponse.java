package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Player;
import tn.iit.entity.Role;
import tn.iit.entity.Role;
import tn.iit.entity.FootballTeam;

@Setter
@Getter
public class PlayerResponse {
    private Long id;
    private String fullName;
    private String nationality;
    private Role role;
    private FootballTeam footballTeam;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.fullName = player.getFirstName() + " " + player.getLastName();
        this.nationality = player.getNationality();
        this.role = player.getRole();
        this.footballTeam = player.getFootballTeam();
    }
}
