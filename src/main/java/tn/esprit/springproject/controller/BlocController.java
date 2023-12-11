package tn.esprit.springproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.service.BlocService;

import java.util.List;

@RestController
@RequestMapping("api/bloc")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class BlocController {

    private final BlocService blocService;
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/addbloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/{idBloc}")
    public Bloc updateBloc(@PathVariable long idBloc,@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/all")
    public List<Bloc> findAll(){
        return blocService.findAll();
    }
    @GetMapping("/{idBloc}")
    public Bloc findById(@PathVariable long idBloc){
        Bloc bloc = blocService.findById(idBloc);
        return bloc;
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/delete/{idBloc}")
    public void delete(@PathVariable long idBloc){
        blocService.delete(idBloc);
    }
}
