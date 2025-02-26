package com.crio.xlido.services;

import com.crio.xlido.entities.Event;
import com.crio.xlido.repositories.IEventRepository;
import com.crio.xlido.repositories.IUserRepository;

public class EventService {
    private final IEventRepository eventRepository;
    private final IUserRepository userRepository;

    public EventService(IEventRepository eventRepository, IUserRepository userRepository){
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public String createEvent(String name, int organizer_id){
        if(!userRepository.userExist(organizer_id)){
            return "ERROR: User with an id "+ organizer_id + " does not exist";
        }
        Event event = new Event(0, name, organizer_id);
        Event savedEvent = eventRepository.save(event);
        return "Event ID: "+ savedEvent.getId();
    }
    
    public String deleteEvent(int id, int organizerId) {
        
        if(!userRepository.userExist(organizerId)){
            return "ERROR: User with an id "+ organizerId + " does not exist";
        }
        else if(!eventRepository.eventExists(id)) {
            return "ERROR: Event with an id " + id + " does not exist";
        }
        else if(!eventRepository.isOrganizer(id, organizerId)) {
            return "ERROR: User with an id "+ organizerId + " is not a organizer of Event with an id "+ id;
        }
        eventRepository.deleteById(id, organizerId);
        return "EVENT_DELETED " + id;
    }
}
