package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.Entity.Event;

public interface EventRepository extends CrudRepository<Event,Long> {
  @Query("SELECT b FROM Event b WHERE b.idEvent =:idEvent")
    Event retrieveEvenById(@Param("idEvent") int idEvent);

    public Event findByIdEvent(Long id);

}


