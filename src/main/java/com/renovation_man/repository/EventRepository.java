package com.renovation_man.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.renovation_man.model.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	public List<Event> findAll();
	
	public Event findByIdEvent(Integer idEvent);

}