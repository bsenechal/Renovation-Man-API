package com.renovation_man.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Event;
import com.renovation_man.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<Event> findAllEvents() {
        
        return eventRepository.findAll();
    }
    
    public Event findByIdEvent(Integer idEvent) {
        
        return eventRepository.findByIdEvent(idEvent);
    }
}
