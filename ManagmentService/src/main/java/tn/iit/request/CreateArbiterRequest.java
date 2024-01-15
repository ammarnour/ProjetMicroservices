package tn.iit.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Setter
@Getter
public class CreateArbiterRequest {
    private String firstName;
    private String lastName;
}
