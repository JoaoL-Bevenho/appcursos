package com.appcursos.controllers.mainpages;

import java.util.Iterator;

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
public class GuestController
{
	@Autowired
	public EventRepository eventRep;
	@Autowired
	public GuestRepository guestRep;
	@Autowired
	public StatusInviteRepository statInvRep;
	
	@RequestMapping(value = "/event-{idEvent}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("idEvent") long idEvent, @Valid Guest guest, BindingResult result, RedirectAttributes attributes)
	{
		Event event = eventRep.findByidEvent(idEvent);
		ModelAndView modAView = new ModelAndView("main-pages/event/eventDetails");
		modAView.addObject("event", event);
		
		Guest guestObj = new Guest();
		Iterable<Guest> guests = guestRep.findByEvent(event);
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
	public String guestRegister(@PathVariable("name") String name, @PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInvite") long idStatusInvite, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/event-{idEvent}";
		}
		else
		{
			Event event = eventRep.findByidEvent(idEvent);
			GuestStatusInvite statusInvite = statInvRep.findByidStatusInvite(idStatusInvite);
			Guest guest = new Guest();
			guest.setNameGuest(name);
			guest.setCpf(cpf);
			guest.setEvent(event);
			guest.setStatusInvite(statusInvite);
			guestRep.save(guest);
			attributes.addFlashAttribute("messageheader", "Guest Added");
			attributes.addFlashAttribute("message", "Guest added with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
	
	@RequestMapping(value = "/edit/guest/{name}/{cpf}/{idEvent}/{idStatusInvite}")
	public String guestEdit(@PathVariable("name") String name, @PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInvite") long idStatusInvite, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/event-{idEvent}";
		}
		else
		{
			guestRep.editGuest(name, cpf, idEvent, idStatusInvite, cpf);
			attributes.addFlashAttribute("messageheader", "Guest Edited");
			attributes.addFlashAttribute("message", "Guest edited with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
	
	@RequestMapping(value = "/delete/guest/{cpf}/{idEvent}")
	public String guestDelete(@PathVariable("cpf") String cpf, @PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors())
		{
			attributes.addFlashAttribute("messageheader", "Error Alert");
			attributes.addFlashAttribute("message", "Verify the information in the fields!");
			attributes.addFlashAttribute("class", "error-msg");
			return "redirect:/event-{idEvent}";
		}
		else
		{
			Guest guest = guestRep.findByCpf(cpf);
			guestRep.delete(guest);
			attributes.addFlashAttribute("messageheader", "Guest Deleted");
			attributes.addFlashAttribute("message", "Guest deleted with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
}
