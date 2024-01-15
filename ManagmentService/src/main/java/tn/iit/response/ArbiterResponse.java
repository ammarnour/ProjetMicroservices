package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Match;

import tn.iit.entity.Arbiter;


import java.util.List;

@Setter
@Getter
public class ArbiterResponse {
    private Long id;
    private String fullName;
    private List<Match> matches;

    public ArbiterResponse(Arbiter arbiter) {
        this.id = arbiter.getId();
        this.fullName = arbiter.getFirstName()+" "+arbiter.getLastName();
        this.matches = arbiter.getMatches();
    }
}
