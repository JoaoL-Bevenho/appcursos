package com.appcursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcursos.models.users.UserLanguage;

public interface UserLanguageRepository extends CrudRepository<UserLanguage, String>
{

}
