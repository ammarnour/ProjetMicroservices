package tn.iit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "arbiters")
public class Arbiter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "arbiter")
    private List<Match> matches;

    private String firstName;
    private String lastName;

    public Arbiter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

