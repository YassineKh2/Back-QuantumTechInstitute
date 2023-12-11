package tn.esprit.springproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.repository.ChambreRepoInt;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreService implements ChambreServiceInt {
    private final ChambreRepoInt chambreServiceInt;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreServiceInt.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreServiceInt.save(chambre);
    }

    @Override
    public List<Chambre> findAll() {
        return (List<Chambre>) chambreServiceInt.findAll();
    }

    @Override
    public Chambre findById(long idChambre) {
        return chambreServiceInt.findById(idChambre).orElse(null);
    }

    @Override
    public void delete(long idChambre) {
        chambreServiceInt.deleteById(idChambre);
    }
}
