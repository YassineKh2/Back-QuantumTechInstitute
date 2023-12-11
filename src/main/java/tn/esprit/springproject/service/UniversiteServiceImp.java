package tn.esprit.springproject.service;

import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteServiceImp implements UniversiteService {
    @Autowired
    private UniversiteRepository repository;
    private FoyerServiceImp FoyerService;
    @Override
    public Universite AddUniversite(Universite Universite) {
        return repository.save(Universite);
    }



    @Override
    public List<Universite> GetAllUniversites() {
        return (List<Universite>) repository.findAll();
    }

    @Override
    public Universite UpdateUniversite(Universite Universite) {
        return repository.save(Universite);
    }

    @Override
    public void DeleteUniversite(Universite Universite) {
        repository.delete(Universite);
    }

    public Universite findByIdUniversite(Long id){ return repository.findByIdUniversite(id); }

    public Universite findByNomUniversite(String nomUni){return repository.findByNomUniversite(nomUni); }
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite uni = findByNomUniversite(nomUniversite);
        Foyer foyer = FoyerService.findByIdFoyer(idFoyer);
        uni.setFoyer(foyer);
        repository.save(uni);
        return uni;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite uni = findByIdUniversite(idUniversite);
        uni.setFoyer(null);
        repository.save(uni);
        return uni;
    }

}
