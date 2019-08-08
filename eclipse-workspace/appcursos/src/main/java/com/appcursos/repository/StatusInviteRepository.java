package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.guests.GuestStatusInvite;

public interface StatusInviteRepository extends CrudRepository<GuestStatusInvite, String>
{
	GuestStatusInvite findByidStatusInvite(long idStatusInvite);
}
