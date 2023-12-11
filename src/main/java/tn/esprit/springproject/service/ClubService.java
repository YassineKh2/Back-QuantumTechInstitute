package tn.esprit.springproject.service;



import tn.esprit.springproject.Entity.Club;

import java.util.List;

public interface ClubService {
    public Club AddClub(Club c);
    public List<Club> GetAllClubs();
    public Club UpdateClub(Club c);
    public void DeleteClub(Club c);

}
