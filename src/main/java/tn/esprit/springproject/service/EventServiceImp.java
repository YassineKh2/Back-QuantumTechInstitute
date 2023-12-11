package tn.esprit.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Event;
import tn.esprit.springproject.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    private EventRepository repository;

    @Override
    public Event AddEvent(Event Event) {
        return repository.save(Event);
    }

    @Override
    public List<Event> GetAllEvents() {
        return (List<Event>) repository.findAll();
    }

    @Override
    public Event UpdateEvent(Event Event) {
        return repository.save(Event);
    }

    @Override
    public void DeleteEvent(Event Event) {
        repository.delete(Event);
    }

    public Event findByIdEvent(Long id){ return repository.findByIdEvent(id); }

   


}
