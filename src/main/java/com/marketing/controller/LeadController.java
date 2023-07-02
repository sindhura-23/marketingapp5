package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;



@Controller
public class LeadController 
{
	
		@Autowired
		private LeadService leadservice;
		
		@RequestMapping("/viewLeadPage")
		public String viewCreateLeadPage()
		{
			return"create_lead";
		}
		
		@RequestMapping("/save")
		public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model)
		{
			leadservice.saveOneLead(l);
			model.addAttribute("msg", "Record is saved.....!");
			return"create_lead";
		 }
		
//		@RequestMapping("/save")
//		public String saveLead(@RequestParam("name") String fname, @RequestParam("lastName") String lname, @RequestParam("email") String email, @RequestParam("mobile") String mobile)
//		{
//			Lead lead = new Lead();
//			lead.setFistName(fname);
//			lead.setLastName(lname);
//			lead.setEmail(email);
//			lead.setMobile(mobile);
//			
//			leadservice.saveOneLead(lead);
//			return"create_lead";
//		}
		
//		@RequestMapping("/save")
//		public String saveLead(LeadData data)
//		{
//			Lead l = new Lead();
//			l.setFistName(data.getFname());
//			l.setLastName(data.getlName());
//			l.setEmail(data.getEmail());
//			l.setMobile(data.getMobile());
//			leadservice.saveOneLead(l);
//			return"create_lead";
//		 }
		 
		 
		@RequestMapping("/listAll")
		public String listAllLeads(ModelMap model)
		{
			List<Lead> leads = leadservice.listAllLeads();
			model.addAttribute("leads",leads);
			return "list_leads";
		 }
		
		
		@RequestMapping("/deleteLead")
		public String deleteLead(@RequestParam("id") long id, ModelMap model)
		{
			leadservice.deleteOneLead(id);
			
			List<Lead> leads = leadservice.listAllLeads();
			model.addAttribute("leads",leads);
			return "list_leads";
		 }
		
		
		@RequestMapping("/updateLead")
		public String updateLead(@RequestParam("id") long id, ModelMap model)
		{
			
			Lead lead = leadservice.getById(id);
			model.addAttribute("lead",lead);
			
			return "update_leads";
		 }
		
		
		@RequestMapping("/update")
		public String updateLead(@ModelAttribute("Lead") Lead l, Model model)
		{
			
			leadservice.saveOneLead(l);
			
			List<Lead> leads = leadservice.listAllLeads();
			model.addAttribute("leads",leads);
			model.addAttribute("msg", "Lead Updated");
			return "list_leads";
			
		 }
}













