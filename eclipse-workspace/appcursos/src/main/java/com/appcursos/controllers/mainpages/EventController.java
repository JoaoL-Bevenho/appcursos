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

import com.appcursos.models.Event;
import com.appcursos.models.EventGuest;
import com.appcursos.models.GuestStatusInvite;
import com.appcursos.repository.EventRepository;
import com.appcursos.repository.GuestRepository;
import com.appcursos.repository.StatusInviteRepository;
@Controller
public class EventController {
	@Autowired
	public EventRepository eventRep;
	@Autowired
	public GuestRepository guestRep;
	@Autowired
	public StatusInviteRepository statInvRep;
	
	@RequestMapping(value = "/events")
	public ModelAndView listEventsGet()
	{
		ModelAndView modAView = new ModelAndView("main-pages/eventList");
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
	
	@RequestMapping(value = "/events/{idEvent}", method = RequestMethod.GET)
	public ModelAndView detailsEventGet(@PathVariable("idEvent") long idEvent, @Valid EventGuest guest, BindingResult result, RedirectAttributes attributes)
	{
		Event event = eventRep.findByidEvent(idEvent);
		ModelAndView modAView = new ModelAndView("main-pages/eventDetails");
		modAView.addObject("event", event);
		
		EventGuest guestObj = new EventGuest();
		Iterable<EventGuest> guests = guestRep.findByEvent(event);
		modAView.addObject("guests", guests);
		
		int checkStatInvs=0;
		Iterable<GuestStatusInvite> statusInvites = statInvRep.findAll();
		Iterator<GuestStatusInvite> statInvIt = statusInvites.iterator();
		while(statInvIt.hasNext()) { statInvIt.next(); checkStatInvs=checkStatInvs+1; }
		if(checkStatInvs==0)
		{
			String[] statInvList = {"Confirmed", "Interested", "Not Confirmed", "Refused", "Cancelled"};
			GuestStatusInvite statInvObj;
			for(int i=0;i<statInvList.length;i++)
			{
				statInvObj = new GuestStatusInvite();
				statInvObj.setStatusInvite(statInvList[i]);
				statInvRep.save(statInvObj);
			}
			statusInvites = statInvRep.findAll();
		}
		modAView.addObject("statInvsList", statusInvites);
		modAView.addObject("guestObj", guestObj);
		return modAView;
	}
	
	@RequestMapping(value = "/register/guest/{name}/{cpf}/{idEvent}/{idStatusInvite}")
	public String registerGuest(@PathVariable("name") String name, @PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInvite") long idStatusInvite, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
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
			GuestStatusInvite statusInvite = statInvRep.findByidStatusInvite(idStatusInvite);
			EventGuest guest = new EventGuest();
			guest.setNameGuest(name);
			guest.setCpf(cpf);
			guest.setEvent(event);
			guest.setStatusInvite(statusInvite);
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
	
	@RequestMapping(value = "/edit/guest/{name}/{cpf}/{idEvent}/{idStatusInvite}")
	public String editGuest(@PathVariable("name") String name, @PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInvite") long idStatusInvite, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
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
			guestRep.editGuest(name, cpf, idEvent, idStatusInvite, cpf);
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
			Iterable<EventGuest> guests = guestRep.findByEvent(event);
			for(EventGuest guest: guests)
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
			EventGuest guest = guestRep.findByCpf(cpf);
			guestRep.delete(guest);
			attributes.addFlashAttribute("messageheader", "Guest Deleted");
			attributes.addFlashAttribute("message", "Guest deleted with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/{idEvent}";
		}
	}
	
}
