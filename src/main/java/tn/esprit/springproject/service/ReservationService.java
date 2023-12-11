package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public List<Reservation> getres();
    public Optional<Reservation> getReservationById(String idReservation);
    Reservation updateReservation(Reservation res);

    public void deleteReservation(String idReservation);

    public List<Reservation> getReservationByEtudiantEcole(String ecole);
}
