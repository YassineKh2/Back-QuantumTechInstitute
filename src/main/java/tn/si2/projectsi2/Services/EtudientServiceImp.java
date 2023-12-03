package tn.si2.projectsi2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.si2.projectsi2.Repositories.EtudientRepository;

@Service
public class EtudientServiceImp implements EtudientService {
    @Autowired
    private EtudientRepository repository;

}
