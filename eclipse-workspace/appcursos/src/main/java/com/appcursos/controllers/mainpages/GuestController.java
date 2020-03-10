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
import com.appcursos.repository.StatusInviteGuestRepository;

@Controller
public class GuestController
{
	@Autowired
	public EventRepository eventRep;
	@Autowired
	public GuestRepository guestRep;
	@Autowired
	public StatusInviteGuestRepository statInvRep;
	
	@RequestMapping(value = "/event-{idEvent}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("idEvent") long idEvent, @Valid Guest guestEvent, BindingResult result, RedirectAttributes attributes)
	{
		Event event = eventRep.findByidEvent(idEvent);
		ModelAndView modAView = new ModelAndView("main-pages/event/eventDetails");
		modAView.addObject("event", event);
		
		Guest guestObj = new Guest();
		Iterable<Guest> guestsEvent = guestRep.findByEventGuest(event);
		modAView.addObject("guests", guestsEvent);
		
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
				statInvObj.setStatusInviteGuest(statInvList[i]);
				statInvRep.save(statInvObj);
			}
			statusInvites = statInvRep.findAll();
		}
		modAView.addObject("statInvsList", statusInvites);
		modAView.addObject("guestObj", guestObj);
		return modAView;
	}
	
	@RequestMapping(value = "/register/guest/{nameGuest}/{cpfGuest}/{idEvent}/{idStatusInviteGuest}")
	public String guestRegister(@PathVariable("nameGuest") String nameGuest, @PathVariable("cpfGuest") String cpfGuest, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInviteGuest") long idStatusInviteGuest, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
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
			GuestStatusInvite statusInviteGuest = statInvRep.findByidStatusInviteGuest(idStatusInviteGuest);
			Guest guest = new Guest();
			guest.setNameGuest(nameGuest);
			guest.setCpfGuest(cpfGuest);
			guest.setEventGuest(event);
			guest.setStatusInviteGuest(statusInviteGuest);
			guestRep.save(guest);
			attributes.addFlashAttribute("messageheader", "Guest Added");
			attributes.addFlashAttribute("message", "Guest added with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
	
	@RequestMapping(value = "/edit/guest/{nameGuest}/{cpfnewGuest}/{cpfoldGuest}/{idEvent}/{idStatusInviteGuest}")
	public String guestEdit(@PathVariable("nameGuest") String nameGuest, @PathVariable("cpfnewGuest") String cpfnewGuest, @PathVariable("cpfoldGuest") String cpfoldGuest, @PathVariable("idEvent") long idEvent, @PathVariable("idStatusInviteGuest") long idStatusInviteGuest, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
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
			guestRep.editGuest(nameGuest, cpfnewGuest, idEvent, idStatusInviteGuest, cpfoldGuest);
			attributes.addFlashAttribute("messageheader", "Guest Edited");
			attributes.addFlashAttribute("message", "Guest edited with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
	
	@RequestMapping(value = "/delete/guest/{cpfGuest}/{idEvent}")
	public String guestDelete(@PathVariable("cpfGuest") String cpfGuest, @PathVariable("idEvent") long idEvent, @Valid Object objEx, BindingResult result, RedirectAttributes attributes)
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
			Guest guest = guestRep.findByCpfGuest(cpfGuest);
			guestRep.delete(guest);
			attributes.addFlashAttribute("messageheader", "Guest Deleted");
			attributes.addFlashAttribute("message", "Guest deleted with success!");
			attributes.addFlashAttribute("class", "success-msg");
			return "redirect:/event-{idEvent}";
		}
	}
}
