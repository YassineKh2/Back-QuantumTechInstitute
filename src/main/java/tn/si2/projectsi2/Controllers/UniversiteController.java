package tn.si2.projectsi2.Controllers;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.si2.projectsi2.Entites.Universite;
import tn.si2.projectsi2.Services.UniversiteServiceImp;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:4200/")
public class UniversiteController {
    @Autowired
    UniversiteServiceImp UniversiteServiceImp;

    @GetMapping("/getAllUniversites")
    public Iterable<Universite> getAllUniversites() {
        return UniversiteServiceImp.GetAllUniversites();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite Uni) {
        return UniversiteServiceImp.AddUniversite(Uni);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return UniversiteServiceImp.findByIdUniversite(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteUniversite")
    public void deleteUniversite(@RequestBody Universite Uni) {
        UniversiteServiceImp.DeleteUniversite(Uni);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversiteById(@PathVariable Long id) {
        Universite uni = UniversiteServiceImp.findByIdUniversite(id);
        UniversiteServiceImp.DeleteUniversite(uni);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite Uni) {
        return UniversiteServiceImp.UpdateUniversite(Uni);
    }
}
