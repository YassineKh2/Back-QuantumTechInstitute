package tn.esprit.springproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReclamation")
    private Long idReclamation;
    @Column(name = "titre")
    private String titre;
    @Column(name = "message")
    private String message;
    @Column(name = "email")
    private String email;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    private Etudiant etudiant;
}
