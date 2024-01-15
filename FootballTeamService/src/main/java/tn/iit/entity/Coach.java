package tn.iit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "coachs")
public class Coach implements Serializable {

    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_footballteam") 
    FootballTeam footballTeam; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    public Coach(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}