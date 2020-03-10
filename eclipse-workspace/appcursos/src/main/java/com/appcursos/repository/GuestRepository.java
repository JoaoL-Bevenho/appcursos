package com.appcursos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.events.Event;
import com.appcursos.models.guests.Guest;

public interface GuestRepository extends CrudRepository<Guest, String>
{
	Iterable<Guest> findByEventGuest(Event eventGuest);
	
	Guest findByCpfGuest(String cpfGuest);
	
	@Query(value="UPDATE appcursos.guest g SET g.name_guest=?, g.cpf_guest=?, g.event_guest_id_event=?, g.status_invite_guest_id_status_invite_guest=? WHERE g.cpf_guest=?", nativeQuery=true)
	@Modifying
    @Transactional
	void editGuest(String nameGuest, String cpfGuest, long idEvent, long idStatusInviteGuest, String cpfWhere);
	
	@Query(value="TRUNCATE TABLE appcursos.guest", nativeQuery = true)
	@Modifying
    @Transactional
    void truncate();
}
