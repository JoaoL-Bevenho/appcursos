package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Event;

public interface EventRepository extends CrudRepository<Event, String> {
	Event event = new Event();
	long idEvent = event.getIdEvent();

	Event findByidEvent(long idEvent);
}
