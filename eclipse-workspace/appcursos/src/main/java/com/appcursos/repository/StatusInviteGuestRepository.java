package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.guests.GuestStatusInvite;

public interface StatusInviteGuestRepository extends CrudRepository<GuestStatusInvite, String>
{
	GuestStatusInvite findByidStatusInviteGuest(long idStatusInviteGuest);
}
