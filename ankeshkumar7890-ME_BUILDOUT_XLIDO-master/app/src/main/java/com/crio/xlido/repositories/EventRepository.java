package com.crio.xlido.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.crio.xlido.entities.Event;

public class EventRepository implements IEventRepository{
    Map<Integer, Event> eventMap = new HashMap<>();
    private int eventId = 1;
    @Override
    public Event save(Event event) {
        event = new Event(eventId++, event.getName(), event.getOrganizerId());{
        eventMap.put(event.getId(), event);
        return event;
        }

    }

    @Override
    public Optional<Event> findById(int id) {
        return Optional.ofNullable(eventMap.get(id));
    }

    @Override
    public void deleteById(int eventId, int userId) {
        eventMap.remove(eventId);
    }

    @Override
    public boolean eventExists(int id) {
        return eventMap.containsKey(id);
    }

    @Override
    public boolean isOrganizer(int eventId, int organizerId) {
        return eventMap.get(eventId).getOrganizerId() == organizerId;
    }
    
}
