package tn.si2.projectsi2.Entites;

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
@Table(name = "Chambre")
public class Chambre implements Serializable {
    public enum RoomType {
        SIMPLE,
        DOUBLE,
        TRIPLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idChambre")
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private RoomType TypeChambre;
    @ManyToOne
    private Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> Reservation;

}
