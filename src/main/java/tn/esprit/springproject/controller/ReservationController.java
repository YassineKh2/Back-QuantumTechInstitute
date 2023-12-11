package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.*;
import tn.esprit.springproject.service.ReservationService;
import tn.esprit.springproject.service.ReservationServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    /*@GetMapping("/")
    public List<Reservation> getReservationByEtudiantEcole(@RequestParam String ecole) {
        return reservationService.getReservationByEtudiantEcole(ecole);
    }*/
    @GetMapping("/getAllReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getres();
    }

    @GetMapping("/getReservationById/{id}")
    public Optional<Reservation> getReservationByID(@PathVariable String id) {
        return reservationService.getReservationById(id);
    }
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return reservationService.updateReservation(r);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }
}
