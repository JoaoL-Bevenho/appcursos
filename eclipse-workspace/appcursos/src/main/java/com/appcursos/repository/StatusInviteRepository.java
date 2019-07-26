package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.GuestStatusInvite;

public interface StatusInviteRepository extends CrudRepository<GuestStatusInvite, String>
{
	GuestStatusInvite findByidStatusInvite(long idStatusInvite);
}
