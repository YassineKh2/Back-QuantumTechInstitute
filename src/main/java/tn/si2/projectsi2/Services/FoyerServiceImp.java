package tn.si2.projectsi2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.si2.projectsi2.Entites.Bloc;
import tn.si2.projectsi2.Entites.Foyer;
import tn.si2.projectsi2.Entites.Universite;
import tn.si2.projectsi2.Repositories.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImp implements FoyerService {
    @Autowired
    private FoyerRepository repository;
    private BlocServiceImp BlocService;
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
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        for(Bloc b : foyer.getBlocs()){
            BlocService.AddBloc(b);
        }
        repository.save(foyer);

        Universite uni = UniService.findByIdUniversite(idUniversite);

        uni.setFoyer(foyer);

        UniService.UpdateUniversite(uni);

        return foyer;
    }
}
