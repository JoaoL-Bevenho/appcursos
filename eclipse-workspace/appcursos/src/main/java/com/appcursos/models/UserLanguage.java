package com.appcursos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "language")
public class UserLanguage
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idLanguage;
	@NotEmpty
	@Column(length = 255)
	private String language;
	
	
	@Override
	public String toString()
	{
		String toStrVar="";
		toStrVar = "Language [idLanguage=" + this.idLanguage + ", language=" + this.language + "]";
		return toStrVar;
	}
	
	public long getIdLanguage() { return idLanguage; }
	public void setIdLanguage(long idLanguage) { this.idLanguage = idLanguage; }
	
	public String getLanguage() { return language; }
	public void setLanguage(String language) { this.language = language; }
}
