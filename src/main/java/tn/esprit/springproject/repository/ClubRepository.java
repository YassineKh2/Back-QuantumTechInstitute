package tn.esprit.springproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.springproject.Entity.Club;


public interface ClubRepository extends CrudRepository<Club,Long> {
    @Query("SELECT b FROM Club b WHERE b.idClub =:idClub")
    public Club findByIdClub(Long idClub);
    public Club findByNomClub(String nomClub);
}


