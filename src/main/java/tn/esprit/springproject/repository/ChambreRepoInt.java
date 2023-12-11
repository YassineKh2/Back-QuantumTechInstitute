package tn.esprit.springproject.repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.springproject.Entity.Chambre;

public interface ChambreRepoInt extends CrudRepository<Chambre, Long> {
}
