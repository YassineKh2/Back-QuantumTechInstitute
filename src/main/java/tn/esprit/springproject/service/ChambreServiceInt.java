package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Chambre;

import java.util.List;

public interface ChambreServiceInt {
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    List<Chambre> findAll();
    Chambre findById(long idChambre);
    void delete(long idChambre);
}
