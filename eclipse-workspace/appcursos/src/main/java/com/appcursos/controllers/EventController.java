package com.appcursos.controllers;

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

import com.appcursos.models.Event;
import com.appcursos.models.Guest;
import com.appcursos.models.StatusInviteGuest;
import com.appcursos.repository.EventRepository;
import com.appcursos.repository.GuestRepository;
import com.appcursos.repository.StatusInviteGuestRepository;

@Controller
public class EventController {
	@Autowired
	public EventRepository eventRep;
	@Autowired
	public GuestRepository guestRep;
	
	@Autowired
	public StatusInviteGuestRepository statusInviteGuestRep;
	
	@RequestMapping(value = "/events")
	public ModelAndView listEventsGet()
	{
		ModelAndView modAView = new ModelAndView("index");
		Iterable<Event> events = eventRep.findAll();
		modAView.addObject("events", events);
		return modAView;
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public String listEventsPost(@Valid Event pEvent, BindingResult result, RedirectAttributes attributes)
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
			eventRep.save(pEvent);
			attributes.addFlashAttribute("messageheader", "Event Created");
			attributes.addFlashAttribute("message", "Event created with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/events";
		}
	}

	@RequestMapping(value = "/{idEvent}", method = RequestMethod.GET)
	public ModelAndView detailsEventGet(@PathVariable("idEvent") long idEvent, @Valid Guest guest, BindingResult result, RedirectAttributes attributes)
	{
		Event event = eventRep.findByidEvent(idEvent);
		ModelAndView modAView = new ModelAndView("event/detailsEvent");
		modAView.addObject("event", event);
		
		Iterable<Guest> guests = guestRep.findByEvent(event);
		modAView.addObject("guests", guests);
		
		int checkStatusInviteGuest=0;
		Iterable<StatusInviteGuest> statusInvite = statusInviteGuestRep.findAll();
		Iterator<StatusInviteGuest> statusInviteIt = statusInvite.iterator();
		while(statusInviteIt.hasNext()){statusInviteIt.next(); checkStatusInviteGuest=checkStatusInviteGuest+1; }
		if(checkStatusInviteGuest==0)
		{
			List<StatusInviteGuest> stsInvtList = new ArrayList<StatusInviteGuest>();
			stsInvtList.add(new StatusInviteGuest("Comparecerá"));
			stsInvtList.add(new StatusInviteGuest("Interessado"));
			stsInvtList.add(new StatusInviteGuest("Não irá Comparecer"));
			stsInvtList.add(new StatusInviteGuest("Não Confirmou"));
			for(StatusInviteGuest stsInvt: stsInvtList)
			{
				statusInviteGuestRep.save(stsInvt);
				statusInvite = statusInviteGuestRep.findAll();				
			}
		}
		modAView.addObject("statusinvites", statusInvite);
		return modAView;
	}
	
	@RequestMapping(value = "/{idEvent}", method = RequestMethod.POST)
	public String detailsEventPost(@PathVariable("idEvent") long idEvent, @Valid Guest guest, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:{idEvent}";
		}
		else
		{
			Event event = eventRep.findByidEvent(idEvent);
			guest.setEvent(event);
			guestRep.save(guest);
			attributes.addFlashAttribute("messageheader", "Guest Added");
			attributes.addFlashAttribute("message", "Guest added with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:{idEvent}";
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
	
	@RequestMapping(value = "/edit/guest/{name}/{cpf}/{idEvent}")
	public String editGuest(@PathVariable("name") String name, @PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/{idEvent}";
		}
		else
		{
			guestRep.editGuest(name, cpf, idEvent, cpf);
			attributes.addFlashAttribute("messageheader", "Guest Edited");
			attributes.addFlashAttribute("message", "Guest edited with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/{idEvent}";
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
	
	@RequestMapping(value = "/delete/guest/{cpf}/{idEvent}")
	public String deleteGuest(@PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/{idEvent}";
		}
		else
		{
			Guest guest = guestRep.findByCpf(cpf, idEvent);
			guestRep.delete(guest);
			attributes.addFlashAttribute("messageheader", "Guest Deleted");
			attributes.addFlashAttribute("message", "Guest deleted with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/{idEvent}";
		}
	}
	
}
