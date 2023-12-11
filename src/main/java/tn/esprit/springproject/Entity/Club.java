package tn.esprit.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idClub")
    private Long idClub;
    private String nomClub;
    private String type;
    private String DescriptionClub;
    private String image;
    private LocalDate dateCreation;
    private String Contact;
    private String status;
    @ManyToOne
    private Universite universite;

    @JsonIgnore
    @OneToMany(mappedBy = "Club", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events = new ArrayList<>();
}
