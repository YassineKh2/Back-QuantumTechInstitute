package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Etudiant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    public List<Etudiant> findByReservationsEstValide(Boolean estValide);

    @Query("SELECT etudiant FROM Etudiant etudiant JOIN etudiant.reservations reservation WHERE reservation.anneeUniversitaire = :anneeUniversitaire")
    public Bloc findByReservationsAnneeUniversitaire(@Param("anneeUniversitaire") Date anneeUniversitaire);
    public Etudiant findByEmailAndPassword(String email,String password);
    public Etudiant findByEmail(String email);
    public List<Etudiant> findByNomEtContainingIgnoreCase(String NomEt);

}
