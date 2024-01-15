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
@Table(name = "players")
public class Player implements Serializable {

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_footballteam")
    FootballTeam footballTeam;
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Player(String firstName, String lastName, String nationality, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.role = role;
    }

}