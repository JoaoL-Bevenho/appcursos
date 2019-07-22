package com.appcursos.repository;

import java.sql.Date;
import java.sql.Time;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Event;

public interface EventRepository extends CrudRepository<Event, String> {
	Event event = new Event();
	long idEvent = event.getIdEvent();

	Event findByidEvent(long idEvent);
	
	@Query(value="UPDATE appcursos.event e SET e.name=?, e.place=?,e.date=?, e.time=? WHERE e.id_event=?", nativeQuery=true)
	@Modifying
    @Transactional
	void editEvent(String name, String place, String date, String time, long idEvent);
	
    @Query(value="TRUNCATE TABLE appcursos.event", nativeQuery = true)
	@Modifying
    @Transactional
    void truncate();
}
