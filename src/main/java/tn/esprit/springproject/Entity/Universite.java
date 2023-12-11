package tn.esprit.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idUniversite")
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    private String ImageUni;
    @OneToOne
    private Foyer Foyer;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="universite")
    private Set<Club> clubs;

}
