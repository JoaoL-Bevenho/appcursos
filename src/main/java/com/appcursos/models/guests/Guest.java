package com.appcursos.models.guests;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.appcursos.models.events.Event;

@Entity
@Table(name = "guest")
public class Guest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(length = 50)
	private String cpfGuest;
	@NotEmpty
	@Column(length = 255)
	private String nameGuest;
	
	@OneToOne
	private GuestStatusInvite statusInviteGuest;

	@ManyToOne
	private Event eventGuest;
	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "Guest [cpfGuest=" + this.cpfGuest + ", nameGuest=" + this.nameGuest + ", statusInviteGuest=";
		toStrVar += this.statusInviteGuest.getStatusInviteGuest() + ", eventGuest=" + this.eventGuest.getNameEvent() + "]";
		return toStrVar;
	}
	
	public String getCpfGuest() { return cpfGuest; }
	public void setCpfGuest(String cpfGuest) { this.cpfGuest = cpfGuest; }

	public String getNameGuest() { return nameGuest; }
	public void setNameGuest(String nameGuest) { this.nameGuest = nameGuest; }

	public GuestStatusInvite getStatusInviteGuest() { return statusInviteGuest; }
	public void setStatusInviteGuest(GuestStatusInvite statusInviteGuest) { this.statusInviteGuest = statusInviteGuest; }
	
	public Event getEventGuest() { return eventGuest; }
	public void setEventGuest(Event eventGuest) { this.eventGuest = eventGuest; }
}
