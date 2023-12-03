package tn.si2.projectsi2.Services;

import tn.si2.projectsi2.Entites.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation AddReservation(Reservation Res);
    public List<Reservation> GetAllReservations();
    public Reservation UpdateReservation(Reservation Res);
    public void DeleteReservation(Reservation Res);
    public Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant) ;
}
