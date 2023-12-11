package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;
import tn.esprit.springproject.service.EtudiantService;
import tn.esprit.springproject.service.EtudiantServiceImp;
import tn.esprit.springproject.service.PdfService;
import tn.esprit.springproject.service.ReclamationService;
import tn.esprit.springproject.utils.JwtUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    private PdfService pdfService;
    @Autowired
    private ReclamationService reclamationService;
    @Value("C:\\Users\\nassi\\OneDrive\\Bureau\\Mini Project Angular\\frontend angular\\src\\assets\\imageProfile\\")
    private String uploadPath;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(@RequestBody Etudiant e) throws IOException {
        List<Reclamation> reclamations = reclamationService.getListReclamation(e.getIdEtudiant());

        byte[] pdfContent = pdfService.generatePdf(e,reclamations);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "student_profile.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContent);
    }
    @Autowired
    private JwtUtil jwtUtil;
   /* @Autowired
    private AuthenticationManager authenticationManager;*/
    /*@GetMapping("/")
    public List<Etudiant> getEtudiantByEstValide(@RequestParam Boolean estValide) {
        return etudiantService.getEtudiantByEstValide(estValide);
    }*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getet();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addet(e);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getEtudiantById/{id}")
    public Optional<Etudiant> getEtudiantByID(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public Etudiant login(@RequestBody Etudiant etudiant){
        Etudiant PresentEtudiant = etudiantService.getEtudiantByEmailAndPassword(etudiant.getEmail(),etudiant.getPassword());
        return PresentEtudiant;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/verifyEmail/{email}")
    public Etudiant verifyEmail(@PathVariable String email){
        Etudiant PresentEtudiant = etudiantService.getEtudiantByEmail(email);
        return PresentEtudiant;
    }
    @PostMapping("/getEtudiantDetail")
    @CrossOrigin(origins = "http://localhost:4200")
    public Etudiant getEtudiantProfileDetail(@RequestBody Etudiant etudiant) {
        return etudiantService.getEtudiantProfileDetail(etudiant.getIdEtudiant());
    }
    @PostMapping("/upload-file")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + file.getOriginalFilename());
            Files.write(path, bytes);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search/{nomEt}")
    public ResponseEntity<List<Etudiant>> searchBlocsByNomBloc(@PathVariable String nomEt) {
        List<Etudiant> etudiants = etudiantService.searchEtudiantsByNomEtudiant(nomEt);
        return ResponseEntity.ok(etudiants);
    }
}
