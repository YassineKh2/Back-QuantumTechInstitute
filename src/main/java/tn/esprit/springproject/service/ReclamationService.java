package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {
    public Reclamation addReclamation(Reclamation reclamation) ;

    public List<Reclamation> getReclamation();
    Reclamation updateReclamation(Reclamation reclamation);

    public void deleteReclamation(Long idReclamation);
    public List<Reclamation> getListReclamation(Long idEtudiant);
    public Optional<Reclamation> getReclamationById(Long idReclamation);
    public List<Reclamation> searchReclamationByTitre(String titre);
}
