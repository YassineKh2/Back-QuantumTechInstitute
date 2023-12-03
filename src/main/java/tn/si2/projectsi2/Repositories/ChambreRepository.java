package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Bloc;
import tn.si2.projectsi2.Entites.Chambre;

import java.util.Set;

public interface ChambreRepository extends CrudRepository<Chambre, Long> {
    @Modifying
    @Query("update Chambre c set c.bloc = :bloc where c.idChambre =:idChambre")
            int updateChambreBlocById(@Param("bloc") Bloc bloc, @Param("idChambre")Long idChambre);

    public Chambre findByIdChambre(Long idChambre);
}


