package tn.si2.projectsi2.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import tn.si2.projectsi2.Services.ReservationServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReservationController {
    @Autowired
    ReservationServiceImp ReservationServiceImp;

}