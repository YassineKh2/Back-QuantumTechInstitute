package tn.esprit.springproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.service.ChambreService;

import java.util.List;

@RestController
@RequestMapping("api/chambre")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ChambreController {
    private final ChambreService chambreService;

    @PostMapping("/addchambre")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Chambre addCourse(@RequestBody Chambre chambre){return chambreService.addChambre(chambre);}
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/updatechambre")
    public Chambre updateCourse(@RequestBody Chambre chambre){return  chambreService.updateChambre(chambre);}
    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<Chambre> findAll() {return chambreService.findAll();}
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/findById/{idChambre}")
    public Chambre findById(@PathVariable long idChambre){
        Chambre chambre = chambreService.findById(idChambre);
        return chambre;
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deletechambre/{idChambre}")
    public void delete(@PathVariable long idChambre){chambreService.delete(idChambre);}
}
