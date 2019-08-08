package com.appcursos.controllers.mainpages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appcursos.models.events.Event;
import com.appcursos.models.guests.Guest;
import com.appcursos.models.guests.GuestStatusInvite;
import com.appcursos.repository.EventRepository;
import com.appcursos.repository.GuestRepository;
import com.appcursos.repository.StatusInviteRepository;

@Controller
public class EventController
{
	@Autowired
	public EventRepository eventRep;
	@Autowired
	public GuestRepository guestRep;
	@Autowired
	public StatusInviteRepository statInvRep;
	
	@RequestMapping(value = "/events")
	public ModelAndView eventList()
	{
		ModelAndView modAView = new ModelAndView("main-pages/event/eventList");
		Iterable<Event> events = eventRep.findAll();
		modAView.addObject("events", events);
		return modAView;
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public String registerEvent(@Valid Event event, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/events";
		}
		else
		{
			eventRep.save(event);
			attributes.addFlashAttribute("messageheader", "Event Created");
			attributes.addFlashAttribute("message", "Event created with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value = "/edit/event/{name}/{place}/{date}/{time}/{idEvent}")
	public String editEvent(@PathVariable("name") String name, @PathVariable("place") String place, @PathVariable("date") String date, @PathVariable("time") String time, @PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/events";
		}
		else
		{
			eventRep.editEvent(name, place, date, time,idEvent);
			attributes.addFlashAttribute("messageheader", "Event Edited");
			attributes.addFlashAttribute("message", "Event edited with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value = "/delete/event/{idEvent}")
	public String deleteEvent(@PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/events";
		}
		else
		{
			Event event = eventRep.findByidEvent(idEvent);
			Iterable<Guest> guests = guestRep.findByEvent(event);
			for(Guest guest: guests)
			{
				guestRep.delete(guest);
			}
			eventRep.delete(event);
			
			int checkEvents=0;
			Iterable<Event> events = eventRep.findAll();
			Iterator<Event> eventIt = events.iterator();
			while(eventIt.hasNext()){eventIt.next(); checkEvents=checkEvents+1; }
			if(checkEvents==0) { eventRep.truncate(); }
			
			attributes.addFlashAttribute("messageheader", "Event Deleted");
			attributes.addFlashAttribute("message", "Event and Guests deleted with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/events";
		}
	}
}