package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.repository.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImp implements FoyerService {
    @Autowired
    private FoyerRepository repository;

    private UniversiteServiceImp UniService;
    @Override
    public Foyer AddFoyer(Foyer Foyer) {
        return repository.save(Foyer);
    }



    @Override
    public List<Foyer> GetAllFoyers() {
        return (List<Foyer>) repository.findAll();
    }

    @Override
    public Foyer UpdateFoyer(Foyer Foyer) {
        return repository.save(Foyer);
    }

    @Override
    public void DeleteFoyer(Foyer Foyer) {
        repository.delete(Foyer);
    }


    public Foyer findByIdFoyer(Long id){ return repository.findByIdFoyer(id); }

    public Foyer findByNomFoyer(String nomFoyer){ return repository.findByNomFoyer(nomFoyer);}

}
