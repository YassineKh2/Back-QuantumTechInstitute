package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    public List<Reservation> findByEtudiantsEcole(String ecole);
    @Query("SELECT reservation FROM Reservation reservation JOIN reservation.etudiants etudiant WHERE etudiant.nomEt = :nomEt")
    public Bloc findByEtudiantsNomEt(@Param("nomEt") String nomEt);
}
