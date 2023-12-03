package tn.si2.projectsi2.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.si2.projectsi2.Entites.Bloc;

import java.util.Date;
import java.util.List;

public interface BlocRepository extends CrudRepository<Bloc,Long> {
    @Query("SELECT b FROM Bloc b WHERE b.idBloc =:idBloc")
    Bloc retrieveBlocById(@Param("idBloc") int Bloc);

    public Bloc findByIdBloc(Long id);



}


