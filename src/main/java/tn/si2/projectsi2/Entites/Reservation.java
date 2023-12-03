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
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idReservation")
    private Long idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToMany
    private Set<Etudient> Etudients;
}

