package tn.esprit.springproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Reservation implements Serializable {
    @Id
    @Column(name = "idReservation")
    private Long idReservation;

    @Column(name = "anneeUniversitaire")
    private Date anneeUniversitaire;

    @Column(name = "estValide")
    private Boolean estValide;

    @ManyToMany(mappedBy="reservations",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
