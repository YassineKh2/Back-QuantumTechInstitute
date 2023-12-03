package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Foyer;


import java.util.List;

public interface FoyerRepository extends CrudRepository<Foyer,Long> {

    @Query("SELECT Foyer FROM Foyer Foyer"
            + " where Foyer.capaciteFoyer > 20"
            + " and Foyer.capaciteFoyer < 100")
    List<Foyer> retrieveFoyerByCapaciteBetween20and100();
    public Foyer findByIdFoyer(Long id);
    public Foyer findByNomFoyer(String nomFoyer);

}


