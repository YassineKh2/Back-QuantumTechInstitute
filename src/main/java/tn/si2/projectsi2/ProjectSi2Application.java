package tn.si2.projectsi2;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.si2.projectsi2.Controllers.BlocController;
import tn.si2.projectsi2.Entites.*;
import tn.si2.projectsi2.Services.BlocServiceImp;

import java.util.Date;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class ProjectSi2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSi2Application.class, args);
        Etudient edu = new Etudient();
        Foyer f = new Foyer();
        Bloc Blo = new Bloc(10L,"test", 20L,null,null);
        System.out.println(Blo);
        BlocServiceImp blocServiceImp = new BlocServiceImp();

        //blocServiceImp.AddBloc(Blo);


    }

}
