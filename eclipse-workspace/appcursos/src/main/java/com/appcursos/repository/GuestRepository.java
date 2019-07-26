package com.appcursos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Event;
import com.appcursos.models.EventGuest;

public interface GuestRepository extends CrudRepository<EventGuest, String>
{
	Iterable<EventGuest> findByEvent(Event event);
	
	EventGuest findByCpf(String cpf);
	
	@Query(value="UPDATE appcursos.guest g SET g.name_guest=?, g.cpf=?, g.event_id_event=?, g.status_invite_id_status_invite=? WHERE g.cpf=?", nativeQuery=true)
	@Modifying
    @Transactional
	void editGuest(String name, String cpf, long idEvent, long idStatusInvite, String cpfWhere);
	
	@Query(value="TRUNCATE TABLE appcursos.guest", nativeQuery = true)
	@Modifying
    @Transactional
    void truncate();
}
