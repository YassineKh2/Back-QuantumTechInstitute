package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Universite;

import java.util.List;

@Repository
public interface BlocRepository extends CrudRepository<Bloc,Long> {
    public List<Bloc> findByChambresNumeroChambre(Long numeroChambre);

}
