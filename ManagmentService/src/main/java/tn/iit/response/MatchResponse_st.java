package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Arbiter;
import tn.iit.entity.Match;
import tn.iit.entity.Stadium;

import java.util.Date;

@Getter
@Setter
public class MatchResponse_st {

    private Long id;
    private Arbiter arbiter;
    private int spectatorsNumber;
    private Long teamvisitorId;
    private Long teamhomeId;
    private Date matchDate;
    private Stadium stade;

    public MatchResponse_st() {
    }
}
