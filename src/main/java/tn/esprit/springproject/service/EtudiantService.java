package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Etudiant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    public Etudiant addet(Etudiant et) ;

    public List<Etudiant> getet();
    public Optional<Etudiant> getEtudiantById(Long idEtudiant);
    Etudiant updateEtudiant(Etudiant et);

    public void deleteEtudiant(Long idEtudiant);
    public Etudiant getEtudiantByEmailAndPassword(String email, String password);
    public Etudiant getEtudiantByEmail(String email);
    public Etudiant getEtudiantProfileDetail(Long idEtudiant);
    public List<Etudiant> getEtudiantByEstValide(Boolean estValide);
    public List<Etudiant> searchEtudiantsByNomEtudiant(String nomEt);
}
