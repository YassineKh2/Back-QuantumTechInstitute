package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.repository.EtudiantRepository;
import tn.esprit.springproject.repository.EtudiantRepositoryImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImp implements EtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addet(Etudiant et) {
        return etudiantRepository.save(et);
    }

    @Override
    public List<Etudiant> getet() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant) ;
    }
    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepository.save(et);
    }
    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiantByEmailAndPassword(String email,String password) {
        return etudiantRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public Etudiant getEtudiantByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }
    @Override
    public Etudiant getEtudiantProfileDetail(Long idEtudiant) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(idEtudiant);
        if(optionalEtudiant.isPresent()) {
            Etudiant etudiantProfileDetail = optionalEtudiant.get();
            return  etudiantProfileDetail;
        }
        return null;
    }

    @Override
    public List<Etudiant> getEtudiantByEstValide(Boolean estValide) {
        return etudiantRepository.findByReservationsEstValide(estValide);
    }
    @Override
    public List<Etudiant> searchEtudiantsByNomEtudiant(String nomBloc) {
        return etudiantRepository.findByNomEtContainingIgnoreCase(nomBloc);
    }
}
