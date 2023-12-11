package tn.esprit.springproject.repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.springproject.Entity.Bloc;

public interface BlocRepoInt extends CrudRepository<Bloc, Long> {
}
