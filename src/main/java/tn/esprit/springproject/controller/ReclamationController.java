package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;
import tn.esprit.springproject.service.ReclamationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reclamation")
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllReclamation")
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getReclamation();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.updateReclamation(reclamation);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteReclamation/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listReclamation/{idEtudiant}")
    public List<Reclamation> getListReclamation(@PathVariable Long idEtudiant) {
        return reclamationService.getListReclamation(idEtudiant);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getReclamationById/{id}")
    public Optional<Reclamation> getreclamationByID(@PathVariable Long id) {
        return reclamationService.getReclamationById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search/{titre}")
    public ResponseEntity<List<Reclamation>> searchReclamationByTitre(@PathVariable String titre) {
        List<Reclamation> reclamations = reclamationService.searchReclamationByTitre(titre);
        return ResponseEntity.ok(reclamations);
    }

}
