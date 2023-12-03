package tn.si2.projectsi2.Services;

import tn.si2.projectsi2.Entites.Foyer;

import java.util.List;

public interface FoyerService {
    public Foyer AddFoyer(Foyer Uni);
    public List<Foyer> GetAllFoyers();
    public Foyer UpdateFoyer(Foyer Res);
    public void DeleteFoyer(Foyer Res);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
