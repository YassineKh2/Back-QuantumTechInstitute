package tn.esprit.springproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;

import java.util.List;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
    public List<Reclamation> findByEtudiantIdEtudiant(Long idEtudiant);
    public List<Reclamation> findByTitreContainingIgnoreCase(String titre);
}
