package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;
import tn.esprit.springproject.repository.ReclamationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService{
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        Reclamation reclamation1 = reclamationRepository.save(reclamation);
        String email = reclamation.getEmail();
        String subject = "New Reclamation Added";
        String message = "Thank you for your reclamation. We have received it successfully.";
        emailService.sendEmail(email, subject, message);
        return reclamation1;
    }

    @Override
    public List<Reclamation> getReclamation() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void deleteReclamation(Long idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }

    @Override
    public List<Reclamation> getListReclamation(Long idEtudiant) {
        return reclamationRepository.findByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public Optional<Reclamation> getReclamationById(Long idReclamation) {
        return reclamationRepository.findById(idReclamation) ;
    }
    @Override
    public List<Reclamation> searchReclamationByTitre(String titre) {
        return reclamationRepository.findByTitreContainingIgnoreCase(titre);
    }
}
