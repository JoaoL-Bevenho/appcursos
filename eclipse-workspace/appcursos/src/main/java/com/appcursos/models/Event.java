package com.appcursos.models;

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
	private String name;
	@NotEmpty
	@Column(length = 255)
	private String place;
	@NotNull
	@Column
	private Date date;
	@NotNull
	@Column
	private Time time;

	@OneToMany
	private List<EventGuest> guest;

	
	@Override
	public String toString()
	{
		String toStrVar = "";
		toStrVar = "Event [idEvent=" + this.idEvent + ", name=" + this.name + ", place=" + this.place;
		toStrVar += ", date=" + this.date + ", time=" + this.time + ", guest=" + this.guest + "]";
		return  toStrVar;
	}
	
	public long getIdEvent() { return idEvent; }
	public void setIdEvent(long idEvent) { this.idEvent = idEvent; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getPlace() { return place; }
	public void setPlace(String place) { this.place = place; }

	public String getDate()
	{
		String dtStr[] = (String.valueOf(date)).split("-");
		String newDt = dtStr[2] + "/" + dtStr[1] + "/" + dtStr[0]; 
		return newDt;
	}
	public void setDate(String date) { this.date = Date.valueOf(date); }

	public String getTime() { return String.valueOf(time); }
	public void setTime(String time) { this.time = Time.valueOf(time); }

	public List<EventGuest> getGuest() { return guest; }
	public void setGuest(List<EventGuest> guest) { this.guest = guest; }
}
