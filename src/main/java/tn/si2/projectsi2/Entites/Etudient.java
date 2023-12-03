package tn.si2.projectsi2.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Etudient")
public class Etudient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "idEtudient")
    private Long idEtudient;
    private String nomET;
    private String prenomET;
    private Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissace;
    @ManyToMany(mappedBy = "Etudients")
    private Set<Reservation> Reservations;
}
