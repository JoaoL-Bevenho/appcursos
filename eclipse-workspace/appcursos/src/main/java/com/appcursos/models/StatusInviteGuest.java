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
@Table(name = "statusinvite_guest")
public class StatusInviteGuest
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idStatusInviteGuest;
	
	@NotEmpty
	@Column(length = 255)
	private String statusInvite;
	
	public StatusInviteGuest(long idStatusInviteGuest, String statusInvite) {
        super();
        this.idStatusInviteGuest = idStatusInviteGuest;
        this.statusInvite = statusInvite;
    }

	@Override
	public String toString()
	{
		return "StatusInviteGuest [idStatusInviteGuest=" + idStatusInviteGuest + ", statusInvite=" + statusInvite + "]";
	}

	public long getIdStatusInviteGuest() { return idStatusInviteGuest; }
	public void setIdStatusInviteGuest(long idStatusInviteGuest) { this.idStatusInviteGuest = idStatusInviteGuest; }

	public String getStatusInvite() { return statusInvite; }
	public void setStatusInvite(String statusInvite) { this.statusInvite = statusInvite; }
	
	
	
	
}
