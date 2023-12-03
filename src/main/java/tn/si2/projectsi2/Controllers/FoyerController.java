package tn.si2.projectsi2.Controllers;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.si2.projectsi2.Entites.Foyer;
import tn.si2.projectsi2.Services.FoyerServiceImp;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:4200/")
public class FoyerController {
    @Autowired
    FoyerServiceImp FoyerServiceImp;

    @GetMapping("/getAllFoyers")
    public Iterable<Foyer> getAllFoyers(){
        return FoyerServiceImp.GetAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer Uni){
        return FoyerServiceImp.AddFoyer(Uni);
    }

    @GetMapping("/getFoyerById/{id}")
    public Foyer getFoyer(@PathVariable Long id){
        return FoyerServiceImp.findByIdFoyer(id);
    }

    @GetMapping("/getFoyerNomFoyer/{nomFoyer}")
    public Foyer getFoyerByNom(@PathVariable String nomFoyer){
        return FoyerServiceImp.findByNomFoyer(nomFoyer);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteFoyer")
    public void deleteFoyer(@RequestBody Foyer Uni){
        FoyerServiceImp.DeleteFoyer(Uni);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteFoyer/{id}")
    public void deleteFoyerById(@PathVariable Long id){
        Foyer foy = FoyerServiceImp.findByIdFoyer(id);
        FoyerServiceImp.DeleteFoyer(foy);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer Uni){
        return FoyerServiceImp.UpdateFoyer(Uni);
    }

}
