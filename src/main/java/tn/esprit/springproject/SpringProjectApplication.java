package tn.esprit.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.esprit.springproject.Entity.Etudiant;

@SpringBootApplication
public class SpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
        Etudiant et = Etudiant.builder().idEtudiant((long)1).nomEt("ben ali").prenomEt("nassim").ecole("esprit").build();
        System.out.println("Etudiant Information:");
        System.out.println(et);
    }
}
