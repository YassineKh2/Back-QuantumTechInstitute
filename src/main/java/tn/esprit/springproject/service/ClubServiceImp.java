package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Club;
import tn.esprit.springproject.repository.ClubRepository;


import java.util.List;

@Service
public class ClubServiceImp implements ClubService {
    @Autowired
    private ClubRepository repository;
    @Override
    public Club AddClub(Club Club) {
        return repository.save(Club);
    }



    @Override
    public List<Club> GetAllClubs() {
        return (List<Club>) repository.findAll();
    }

    @Override
    public Club UpdateClub(Club C) {
        return repository.save(C);
    }



    @Override
    public void DeleteClub(Club C) {repository.delete(C);}

    public Club findByIdClub(Long idClub){ return repository.findByIdClub(idClub); }

    public Club findByNomClub(String nomClub){return repository.findByNomClub(nomClub); }


}
