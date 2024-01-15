package tn.iit.request;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Arbiter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class CreateMatchRequest {
    private Long id;
    private Arbiter arbiter;
    private int spectatorsNumber;
    private Long teamvisitorId;
    private Long teamhomeId;
    private Date matchDate;
    private Long stadeId;
}
