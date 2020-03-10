package com.appcursos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.events.Event;

public interface EventRepository extends CrudRepository<Event, String>
{
	Event event = new Event();

	Event findByidEvent(long idEvent);
	
	@Query(value="UPDATE appcursos.event e SET e.name_event=?, e.place_event=?,e.date_event=?, e.time_event=? WHERE e.id_event=?", nativeQuery=true)
	@Modifying
    @Transactional
	void editEvent(String nameEvent, String placeEvent, String dateEvent, String timeEvent, long idEvent);
	
    @Query(value="TRUNCATE TABLE appcursos.event", nativeQuery = true)
	@Modifying
    @Transactional
    void truncate();
}
