package tn.iit.response;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Stadium;
import tn.iit.entity.FootballTeam;

import java.util.List;

@Setter
@Getter
public class StadiumResponse {
    private Long id;
    private String name;
    private Long capacity;

    public StadiumResponse(Stadium stadium) {
        this.id = stadium.getId();
        this.name = stadium.getName();
        this.capacity = stadium.getCapacity();
    }
}
