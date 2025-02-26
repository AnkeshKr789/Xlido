package com.crio.xlido.entities;

public class Event {
    private int id;
    private String name;
    private int orgarnizer_id;

    public Event(int id, String name, int orgarnizer_id){
        this.id = id;
        this.name = name;
        this.orgarnizer_id = orgarnizer_id;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrganizerId(){
        return orgarnizer_id;
    }

    @Override
    public String toString() {
        return "Event ID: "+ id;
    }

    
}
