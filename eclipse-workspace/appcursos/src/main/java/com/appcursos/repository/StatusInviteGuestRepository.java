package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Guest;
import com.appcursos.models.StatusInviteGuest;

public interface StatusInviteGuestRepository extends CrudRepository<StatusInviteGuest, String>
{

}
