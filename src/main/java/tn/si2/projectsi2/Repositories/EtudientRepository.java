package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Etudient;

public interface EtudientRepository extends CrudRepository<Etudient,Long> {
    @Modifying
    @Query("DELETE FROM Etudient e WHERE e.idEtudient= :idEtudient")
    int deleteidEtudientByidEtudient(@Param("idEtudient") Long idEtudient);
}


