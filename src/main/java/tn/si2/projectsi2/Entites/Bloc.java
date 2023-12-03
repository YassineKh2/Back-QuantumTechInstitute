package tn.si2.projectsi2.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloc")
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    @ManyToOne
    private Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    @JsonIgnore
    private Set<Chambre> Chambres;

}
