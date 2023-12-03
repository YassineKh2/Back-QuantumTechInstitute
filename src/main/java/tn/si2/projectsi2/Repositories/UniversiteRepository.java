package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Universite;

import java.util.List;

public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    @Query("SELECT Universite FROM Universite Uni"
            + " INNER JOIN Uni.Foyer foy"
            + " where foy.capaciteFoyer =:Capacite")
    List<Universite> retrieveUniversiteByCapciteFoyer(@Param("Capacite") Long Capacite);
    public Universite findByIdUniversite(Long id);
    public Universite findByNomUniversite(String nomUni);
}


