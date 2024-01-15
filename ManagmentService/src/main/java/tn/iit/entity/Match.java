package tn.iit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "matches")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_arbiter")
    private Arbiter arbiter;
    private int spectatorsNumber;
    private Long teamvisitorId;
    private Long teamhomeId;
    private Date matchDate;
    private Long stadeId;


}
