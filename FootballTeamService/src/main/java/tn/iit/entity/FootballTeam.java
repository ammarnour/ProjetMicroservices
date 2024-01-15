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
@Table(name = "footballteams") 
public class FootballTeam implements Serializable { 

    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_coach")
    Coach coach;
    
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_stadium")
    Stadium stadium;
    
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "footballTeam") 
    private List<Player> players;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    public FootballTeam(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
