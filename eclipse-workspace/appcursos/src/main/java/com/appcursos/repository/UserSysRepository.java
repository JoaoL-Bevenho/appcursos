package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.Event;
import com.appcursos.models.UserSys;

public interface UserSysRepository extends CrudRepository<Event, String>
{
	UserSys findByidUserSys(long idUserSys);
}
