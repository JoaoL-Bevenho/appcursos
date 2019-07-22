package com.appcursos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;

@Entity
@Table(name = "guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(length = 50)
	private String cpf;
	@NotEmpty
	@Column(length = 255)
	private String nameGuest;

	@ManyToOne
	private Event event;
	
	@OneToOne
	private StatusInviteGuest statusInviteGuest;

	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getNameGuest() { return nameGuest; }
	public void setNameGuest(String nameGuest) { this.nameGuest = nameGuest; }

	public Event getEvent() { return event; }
	public void setEvent(Event event) { this.event = event; }
	
	public StatusInviteGuest getStatusInviteGuest() { return statusInviteGuest; }
	public void setStatusInviteGuest(StatusInviteGuest statusInviteGuest) { this.statusInviteGuest = statusInviteGuest; }
}
