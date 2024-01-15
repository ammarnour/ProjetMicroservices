package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Arbiter;
import tn.iit.entity.Match;

import java.util.Date;

@Getter
@Setter
public class MatchResponse {

    private Long id;
    private Arbiter arbiter;
    private int spectatorsNumber;
    private Long teamvisitorId;
    private Long teamhomeId;
    private Date matchDate;
    private Long stadeId;

    public MatchResponse(Match match) {
        this.id= match.getId();
        this.matchDate=match.getMatchDate();
        this.stadeId=match.getStadeId();
        this.arbiter=match.getArbiter();
        this.spectatorsNumber=match.getSpectatorsNumber();
        this.teamhomeId= match.getTeamhomeId();
        this.teamvisitorId=match.getTeamvisitorId();
    }
}
