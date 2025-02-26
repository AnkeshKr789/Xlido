package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.EventService;

public class DeleteEventCommand implements ICommand {
    private final EventService eventService;

    public DeleteEventCommand(EventService eventService) {
        this.eventService = eventService;
    }
    @Override
    public void invoke(List<String> tokens) {
        int eventId = Integer.parseInt(tokens.get(1));
        int userId = Integer.parseInt(tokens.get(2));
        System.out.println(eventService.deleteEvent(eventId, userId));
        
    }
    
}
