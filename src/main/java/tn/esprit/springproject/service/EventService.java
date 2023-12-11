package tn.esprit.springproject.service;


import tn.esprit.springproject.Entity.Event;

import java.util.List;

public interface EventService {
    public Event AddEvent(Event e);
    public List<Event> GetAllEvents();
    public Event UpdateEvent(Event e);
    public void DeleteEvent(Event e);

}
