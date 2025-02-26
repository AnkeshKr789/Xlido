package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.EventService;

public class CreateEventCommand implements ICommand{
    private final EventService eventService;

    public CreateEventCommand(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        int organizer_id = Integer.parseInt(tokens.get(2));
        System.out.println(eventService.createEvent(name, organizer_id)); 
    }
    
}
