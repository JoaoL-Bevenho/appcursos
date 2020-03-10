package com.appcursos.models.events;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.appcursos.models.guests.Guest;

@Entity
@Table(name = "event")
public class Event implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idEvent;
	@NotEmpty
	@Column(length = 255)
	private String nameEvent;
	@NotEmpty
	@Column(length = 255)
	private String placeEvent;
	@NotNull
	@Column
	private Date dateEvent;
	@NotNull
	@Column
	private Time timeEvent;

	@OneToMany
	private List<Guest> guestEvent;

	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "Event [idEvent=" + this.idEvent + ", namEvent=" + this.nameEvent + ", placeEvent" + this.placeEvent;
		toStrVar += ", dateEvent=" + this.dateEvent + ", timeEvent=" + this.timeEvent + ", guestEvent=" + this.guestEvent + "]";
		return  toStrVar;
	}
	
	public long getIdEvent() { return idEvent; }
	public void setIdEvent(long idEvent) { this.idEvent = idEvent; }

	public String getNameEvent() { return nameEvent; }
	public void setNameEvent(String nameEvent) { this.nameEvent = nameEvent; }

	public String getPlaceEvent() { return placeEvent; }
	public void setPlaceEvent(String placeEvent) { this.placeEvent = placeEvent; }

	public String getDateEvent()
	{
		String dtStr[] = (String.valueOf(dateEvent)).split("-");
		String newDt = dtStr[2] + "/" + dtStr[1] + "/" + dtStr[0]; 
		return newDt;
	}
	public void setDateEvent(String date) { this.dateEvent = Date.valueOf(date); }

	public String getTimeEvent() { return String.valueOf(timeEvent); }
	public void setTimeEvent(String timeEvent) { this.timeEvent = Time.valueOf(timeEvent); }

	public List<Guest> getGuestEvent() { return guestEvent; }
	public void setGuestEvent(List<Guest> guestEvent) { this.guestEvent = guestEvent; }
}
