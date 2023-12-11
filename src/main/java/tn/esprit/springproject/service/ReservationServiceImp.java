package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Reservation;
import tn.esprit.springproject.repository.ReservationRepository;
import tn.esprit.springproject.repository.ReservationRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getres() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(String idReservation) {
        return  reservationRepository.findById(Long.valueOf(idReservation)) ;
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return  reservationRepository.save(res);
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(Long.valueOf(idReservation));
    }

    @Override
    public List<Reservation> getReservationByEtudiantEcole(String ecole) {
        return reservationRepository.findByEtudiantsEcole(ecole);
    }
}
