package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;

@Controller
public class LeadController 
{
		@Autowired
		private LeadService leadservice;
		
		@Autowired
		private ContactService contactservice;
	
		@GetMapping("/viewCreateLeadpage")
		public String viewCreateLeadPage()
		{
			return "create_new_lead";
		}
		
		
		@PostMapping("/save")
		public String saveLead(@ModelAttribute("lead") Lead lead, Model model)
		{
			leadservice.saveOneLead(lead);
			model.addAttribute("lead", lead);
			return"lead_info";
		}

		@PostMapping("/convertLead")
		public String convertLead(@RequestParam("id") long id, Model model)
		{
			Lead lead = leadservice.findById(id);
			
			Contact contact = new Contact();
			contact.setFirstName(lead.getFirstName());
			contact.setLastName(lead.getLastName());
			contact.setEmail(lead.getEmail());
			contact.setMobile(lead.getMobile());
			contact.setSource(lead.getSource());
			
			contactservice.saveContact(contact);
			
			leadservice.deleteLeadById(id);
			List<Contact> contacts = contactservice.getAllContacts();
			model.addAttribute("contacts", contacts);
			return "list_contacts";
		}
		
		@RequestMapping("/listall")
		public String listALLLeads(Model model)
		{
			List<Lead> leads = leadservice.getAllLeads();
			model.addAttribute("leads", leads);
			return "list_leads";
		}
		
		@RequestMapping("/leadInfo")
		public String leadInfo(@RequestParam("id") long id, Model model)
		{
			Lead lead = leadservice.findById(id);
			model.addAttribute("lead", lead);
			return "lead_info";
		}
}
 