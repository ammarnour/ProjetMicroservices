package tn.iit.request;

import lombok.Getter;
import lombok.Setter;
import tn.iit.entity.Role;

@Setter
@Getter
public class CreatePlayerRequest {
    private String firstName;
    private String lastName;
    private String nationality;
    private Role role;
}
