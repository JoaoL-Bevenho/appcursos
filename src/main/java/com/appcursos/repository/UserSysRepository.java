package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.events.Event;
import com.appcursos.models.users.UserSys;

public interface UserSysRepository extends CrudRepository<UserSys, String>
{
	UserSys findByidUserSys(long idUserSys);
}
