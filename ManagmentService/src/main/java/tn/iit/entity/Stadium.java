package tn.iit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stadium implements Serializable {


    private Long id;
    private String name;
    private Long capacity;

    public Stadium(Long capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }
}
