package tn.si2.projectsi2.Controllers;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.si2.projectsi2.Entites.Universite;
import tn.si2.projectsi2.Services.UniversiteServiceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:4200/")
public class UniversiteController {
    @Autowired
    UniversiteServiceImp UniversiteServiceImp;


    @Value("C:\\Users\\yassine\\Desktop\\9raya\\AngularProject\\QuantumTechInstitute\\src\\assets\\UniImages\\")
    private String uploadPath;


    @GetMapping("/getAllUniversites")
    public Iterable<Universite> getAllUniversites() {
        return UniversiteServiceImp.GetAllUniversites();
    }
    @PostMapping("/uploadImageUniversite")
    @CrossOrigin(origins = "http://localhost:4200/")
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

    @PostMapping("/addUniversite/{ImageUni}")
    public Universite addUniversite(@RequestBody Universite Uni,@PathVariable String ImageUni) {
        Uni.setImageUni(ImageUni);
        return UniversiteServiceImp.AddUniversite(Uni);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return UniversiteServiceImp.findByIdUniversite(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteUniversite")
    public void deleteUniversite(@RequestBody Universite Uni) {
        UniversiteServiceImp.DeleteUniversite(Uni);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversiteById(@PathVariable Long id) {
        Universite uni = UniversiteServiceImp.findByIdUniversite(id);
        UniversiteServiceImp.DeleteUniversite(uni);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite Uni) {
        return UniversiteServiceImp.UpdateUniversite(Uni);
    }
}
