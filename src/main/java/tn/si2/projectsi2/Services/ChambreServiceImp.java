package tn.si2.projectsi2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.si2.projectsi2.Entites.Chambre;
import tn.si2.projectsi2.Repositories.ChambreRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ChambreServiceImp implements ChambreService {
    @Autowired
    private ChambreRepository repository;


    public Chambre findByIdChambre(Long idChambre){ return repository.findByIdChambre(idChambre);}


    @Override
    public Set<Chambre> findChambesByIds(Set<Long> idChambres) {
        Set<Chambre> Chambres = new HashSet<Chambre>();
        for(Long id : idChambres){
            Chambres.add(findByIdChambre(id));
        }

        return Chambres;
    }
}
