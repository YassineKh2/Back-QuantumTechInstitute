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
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @Column(name = "idEtudiant")
    private Long idEtudiant;
    @Column(name = "nomEt")
    private String nomEt;
    @Column(name = "prenomEt")
    private String prenomEt;
    @Column(name = "cin")
    private Long cin;
    @Column(name = "ecole")
    private String ecole;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "picture")
    private String picture;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    private Set<Reclamation> reclamations;
}
