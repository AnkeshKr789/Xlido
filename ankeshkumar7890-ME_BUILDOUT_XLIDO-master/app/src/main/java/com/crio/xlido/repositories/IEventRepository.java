package com.crio.xlido.repositories;

import java.util.Optional;
import com.crio.xlido.entities.Event;

public interface IEventRepository {
    Event save(Event event);
    Optional<Event> findById(int id);
    void deleteById(int eventId, int userId);
    boolean eventExists(int id);
    boolean isOrganizer(int eventId, int organizerId);
    
}
