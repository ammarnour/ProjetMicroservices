package tn.iit.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStadiumRequest {
    private String name;
    private Long Capacity;
}
