package com.appcursos.models.guests;

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
	private long idStatusInviteGuest;
	@NotEmpty
	@Column(length = 255)
	private String statusInviteGuest;
	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "StatusInvite [idStatusInviteGuest=" + this.idStatusInviteGuest + ", statusInviteGuest=" + this.statusInviteGuest + "]";
		return toStrVar;
	}
	
	public long getIdStatusInviteGuest() { return idStatusInviteGuest; }
	public void setIdStatusInviteGuest(long idStatusInviteGuest) { this.idStatusInviteGuest = idStatusInviteGuest;  }
	
	public String getStatusInviteGuest() { return statusInviteGuest; }
	public void setStatusInviteGuest(String statusInviteGuest) { this.statusInviteGuest = statusInviteGuest; }
	
	
	
	
}
