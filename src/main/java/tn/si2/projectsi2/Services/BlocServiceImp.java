package tn.si2.projectsi2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.si2.projectsi2.Entites.Bloc;
import tn.si2.projectsi2.Entites.Chambre;
import tn.si2.projectsi2.Repositories.BlocRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlocServiceImp implements BlocService {
    @Autowired
    private BlocRepository repository;
    private ChambreServiceImp ChambreService;
    @Override
    public Bloc AddBloc(Bloc Bloc) {
        return repository.save(Bloc);
    }


    @Scheduled(fixedRate = 30000)
    @Override
    public List<Bloc> GetAllBlocs() {
        return (List<Bloc>) repository.findAll();
    }

    @Override
    public Bloc UpdateBloc(Bloc Bloc) {
       return repository.save(Bloc);
    }

    @Override
    public void DeleteBloc(Bloc Bloc) {
        repository.delete(Bloc);
    }

    public Bloc findByIdBloc(Long id){ return repository.findByIdBloc(id); }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc blo = findByIdBloc(idBloc);
        Set<Long> numChm = new HashSet<>(numChambre);
        Set<Chambre> chambres = ChambreService.findChambesByIds(numChm);
        blo.setChambres(chambres);

        return blo;
    }
}
