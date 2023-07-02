package com.zohocrm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController 
{
	
	private ContactService contactservice; //Constructor based injection
	
		
	public ContactController(ContactService contactservice) {
		super();
		this.contactservice = contactservice;
	}


	@RequestMapping("/listallcontacts")
	public String listALLLeads(Model model)
	{
		 List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/contactInfo")
	public String leadInfo(@RequestParam("id") long id, Model model)
	{
		Contact contact = contactservice.findById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
}
