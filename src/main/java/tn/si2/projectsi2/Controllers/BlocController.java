package tn.si2.projectsi2.Controllers;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.si2.projectsi2.Entites.Bloc;
import tn.si2.projectsi2.Services.BlocServiceImp;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/bloc")
@CrossOrigin(origins = "http://localhost:4200/")
public class BlocController {
    @Autowired
    BlocServiceImp BlocServiceImp;

    @GetMapping("/getAllBlocs")
    public Iterable<Bloc> getAllBlocs(){
        return BlocServiceImp.GetAllBlocs();
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return BlocServiceImp.AddBloc(bloc);
    }

    @GetMapping("/getBlocById/{id}")
    public Bloc getBlocById(@PathVariable Long id){
        return BlocServiceImp.findByIdBloc(id);
    }

    @DeleteMapping("/deleteBloc")
    public void deleteBloc(@RequestBody Bloc bloc){
        BlocServiceImp.DeleteBloc(bloc);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc){
       return BlocServiceImp.UpdateBloc(bloc);
    }

}











