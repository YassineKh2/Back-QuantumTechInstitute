package tn.esprit.springproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="idEvent")
    private Long idEvent;
    private String nomEvent;
    private String DescriptionEvent;
    private LocalDateTime dateCreation;
    private String location;
    private String image;
    private String organisateur;

  @ManyToOne
    private Club Club;


}
