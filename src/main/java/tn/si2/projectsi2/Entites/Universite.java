package tn.si2.projectsi2.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}
