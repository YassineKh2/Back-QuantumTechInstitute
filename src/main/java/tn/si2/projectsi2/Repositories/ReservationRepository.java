package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    public List<Reservation> findByestValideAndAnneeUniversitaire(boolean etat, Date date);

    @Query("SELECT Reservation FROM Reservation Reses"
            + " INNER JOIN Reses.Etudients etu"
            + " where etu.idEtudient =:idEtudient")

    List<Reservation> retrieveReservationByEtudient(@Param("idEtudient") Long idEtudient);
}


