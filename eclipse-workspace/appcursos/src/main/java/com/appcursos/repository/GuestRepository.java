package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Event;
import com.appcursos.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, String> {
	Iterable<Guest> findByEvent(Event event);
}
