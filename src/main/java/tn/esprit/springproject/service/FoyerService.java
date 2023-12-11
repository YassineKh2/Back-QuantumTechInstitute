package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Foyer;

import java.util.List;

public interface FoyerService {
    public Foyer AddFoyer(Foyer Uni);
    public List<Foyer> GetAllFoyers();
    public Foyer UpdateFoyer(Foyer Res);
    public void DeleteFoyer(Foyer Res);

}
