package tn.si2.projectsi2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.si2.projectsi2.Entites.Reservation;
import tn.si2.projectsi2.Repositories.ReservationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Override
    public Reservation AddReservation(Reservation res) {
        return repository.save(res);
    }

    @Override
    public List<Reservation> GetAllReservations() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public Reservation UpdateReservation(Reservation res) {
        Optional<Reservation> existingReservationOptional = repository.findById(res.getIdReservation());

        if (existingReservationOptional.isPresent()) {
            Reservation existingReservation = existingReservationOptional.get();

            existingReservation.setEtudients(res.getEtudients());
            existingReservation.setAnneeUniversitaire(res.getAnneeUniversitaire());
            existingReservation.setEstValide(res.isEstValide());

            return repository.save(existingReservation);
        } else {
            return null;
        }
    }

    @Override
    public void DeleteReservation(Reservation res) {
        repository.delete(res);
    }

    public List<Reservation> findByestValideAndAnneeUniversitaire(boolean etat, Date date) {
        return repository.findByestValideAndAnneeUniversitaire(etat, date);

    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        return null;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        return null;
    }
}
