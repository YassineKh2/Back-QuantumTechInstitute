package tn.esprit.springproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Event;
import tn.esprit.springproject.service.EventServiceImp;


@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    tn.esprit.springproject.service.EventServiceImp EventServiceImp;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getAllEvents")
   public Iterable<Event> getAlls(){
       return EventServiceImp.GetAllEvents();
   }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/addEvent")
   public Event add(@RequestBody Event e){
        System.out.println(e.getClub().getNomClub());
        return EventServiceImp.AddEvent(e);
   }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getById/{id}")
   public Event get(@PathVariable Long id){
       return EventServiceImp.findByIdEvent(id);
   }


    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/deleteEvent/{id}")
    public void deleteClubById(@PathVariable Long id) {
        Event e = EventServiceImp.findByIdEvent(id);
        EventServiceImp.DeleteEvent(e);}

    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/updateEvent")
   public Event update(@RequestBody Event e){
       return EventServiceImp.UpdateEvent(e);
   }

}
