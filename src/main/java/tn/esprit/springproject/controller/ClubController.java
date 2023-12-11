package tn.esprit.springproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Club;
import tn.esprit.springproject.service.ClubServiceImp;

import java.util.List;

@RestController
@RequestMapping("api/club")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class ClubController {
    @Autowired
    ClubServiceImp clubServiceImp;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getAllClubs")
    public List<Club> getAllClubs(){
        return clubServiceImp.GetAllClubs();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club c){
        return clubServiceImp.AddClub(c);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getClubById/{id}")
    public Club getClub(@PathVariable Long id){
        return clubServiceImp.findByIdClub(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteClub/{id}")
    public void deleteClub(@PathVariable Long id){

        Club c = clubServiceImp.findByIdClub(id);
        clubServiceImp.DeleteClub(c);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/updateClub")
    public Club updateClub(@RequestBody Club c){
        return clubServiceImp.UpdateClub(c);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteClubById(@PathVariable Long id) {
        Club c = clubServiceImp.findByIdClub(id);
        clubServiceImp.DeleteClub(c);}
}
