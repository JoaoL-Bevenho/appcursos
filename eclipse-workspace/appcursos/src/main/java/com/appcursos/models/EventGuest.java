package com.appcursos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "guest")
public class EventGuest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(length = 50)
	private String cpf;
	@NotEmpty
	@Column(length = 255)
	private String nameGuest;
	
	@OneToOne
	private GuestStatusInvite statusInvite;

	@ManyToOne
	private Event event;
	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "Guest [cpf=" + this.cpf + ", nameGuest=" + this.nameGuest;
		toStrVar += ", statusInvite=" + this.statusInvite.getStatusInvite() + ", event=" + this.event + "]";
		return toStrVar;
	}
	
	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getNameGuest() { return nameGuest; }
	public void setNameGuest(String nameGuest) { this.nameGuest = nameGuest; }

	public GuestStatusInvite getStatusInvite() { return statusInvite; }
	public void setStatusInvite(GuestStatusInvite statusInvite) { this.statusInvite = statusInvite; }
	
	public Event getEvent() { return event; }
	public void setEvent(Event event) { this.event = event; }
}
