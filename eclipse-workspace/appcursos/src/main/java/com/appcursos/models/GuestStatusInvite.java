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
@Table(name = "status_invite")
public class GuestStatusInvite
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idStatusInvite;
	@NotEmpty
	@Column(length = 255)
	private String statusInvite;
	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "StatusInvite [idStatusInvite=" + this.idStatusInvite + ", statusInvite=" + this.statusInvite + "]";
		return toStrVar;
	}
	
	public long getIdStatusInvite() { return idStatusInvite; }
	public void setIdStatusInvite(long idStatusInvite) { this.idStatusInvite = idStatusInvite;  }
	
	public String getStatusInvite() { return statusInvite; }
	public void setStatusInvite(String statusInvite) { this.statusInvite = statusInvite; }
	
	
	
	
}
