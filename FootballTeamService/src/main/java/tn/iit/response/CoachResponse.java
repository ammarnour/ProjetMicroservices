package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Coach;
import tn.iit.entity.FootballTeam; 
@Getter
@Setter
public class CoachResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private FootballTeam footballTeam; 

    public CoachResponse(Coach coach){
        this.id = coach.getId();
        this.firstName = coach.getFirstName();
        this.lastName = coach.getLastName();

        this.footballTeam = coach.getFootballTeam(); 
}
}
