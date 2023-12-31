package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Universite;

import java.util.List;

public interface UniversiteService {
    public Universite AddUniversite(Universite Uni);
    public List<Universite> GetAllUniversites();
    public Universite UpdateUniversite(Universite Res);
    public void DeleteUniversite(Universite Res);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
