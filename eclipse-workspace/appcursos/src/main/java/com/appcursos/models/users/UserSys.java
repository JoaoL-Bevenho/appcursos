package com.appcursos.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.appcursos.models.users.UserLanguage;
import com.appcursos.utils.PasswordUtils;

@Entity
@Table(name = "user")
public class UserSys
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idUserSys;
	@NotEmpty
	@Column(length = 255)
	private String nameUser;
	@NotEmpty
	@Column(length = 255)
	private String username;
	@NotEmpty
	@Column(length = 255)
	private String md5EncodedPassword;
	@NotEmpty
	@Column(length = 255)
	private String saltEncodedPassword;
	@NotEmpty
	@Column(length = 255)
	private String saltVar;
	
	@OneToOne
	private UserLanguage language;
	
	@Override
	public String toString()
	{
		String toStrVar="";
		toStrVar = "UserSys [idUserSys=" + this.idUserSys + ", nameUser=" + this.nameUser + ", username=";
		toStrVar += this.username + ", md5EncodedPassword=" + this.md5EncodedPassword + ", saltEncodedPassword=";
		toStrVar +=  this.saltEncodedPassword + ", saltVar=" + this.saltVar + ", language=";
		toStrVar +=  this.language.getLanguage() + "]";
		return  toStrVar;
	}
	public long getIdUserSys() { return idUserSys; }
	public void setIdUserSys(long idUserSys) { this.idUserSys = idUserSys; }

	public String getNameUser() { return nameUser; }
	public void setNameUser(String nameUser) { this.nameUser = nameUser; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getMd5EncodedPassword() { return md5EncodedPassword; }
	public void setMd5EncodedPassword(String md5EncodedPassword)
	{ this.md5EncodedPassword = PasswordUtils.generateMd5Pw(md5EncodedPassword); }

	public String getSaltEncodedPassword() { return saltEncodedPassword; }
	public void setSaltEncodedPassword()
	{
		String md5Pw = this.getMd5EncodedPassword();
		String saltVar = PasswordUtils.getSaltVar(30);
		String encodedSecurePw = PasswordUtils.generateSaltPw(md5Pw, saltVar);
		this.saltEncodedPassword = encodedSecurePw;
		setSaltVar(saltVar);
	}

	public String getSaltVar() { return saltVar; }
	public void setSaltVar(String saltVar) { this.saltVar = saltVar; }

	public UserLanguage getLanguage() { return language; }
	public void setLanguage(UserLanguage language) { this.language = language; }
}
