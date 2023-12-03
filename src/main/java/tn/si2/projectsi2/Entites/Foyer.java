package tn.si2.projectsi2.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idFoyer")
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne(mappedBy = "Foyer")
    @JsonIgnore
    private Universite Universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    @JsonIgnore
    private Set<Bloc> Blocs;
}
