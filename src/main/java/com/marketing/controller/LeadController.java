 package com.marketing.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;
import com.marketing.utilities.EmailService;


@Controller
public class LeadController {
	@Autowired
	private EmailService emailService;
	
	
	@Autowired
	private LeadService leadService;
	@RequestMapping(value = "/viewCreateLeadPage",method = RequestMethod.GET)//method to be define it is get or post
	public String viewCreateLeadPage()
	{
		return "create_lead";//acts like request dispatcher
	}
	
	 @RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead,ModelMap model)
	{
		 
		leadService.saveLead(lead);
		File file = new File("C:\\Users\\tipu\\Downloads\\Documents\\WIS PVT LTD\\WELCOME EMAIL.txt");
	    Scanner sc ;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("\\Z");
			emailService.sendEmail(lead.getEmail(), "Welcome",sc.next() );
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		model.addAttribute("msg", "Lead Saved Successfully");
		return "create_lead"; 
		
	}
	//model attribute does 3things:1.create lead object  2.takes fomr data put into lead object 3.send initial obj. addrerss to lead obj. add

//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("email")String email,@RequestParam("mobile")Long mobile,Model model)
//	{
//		Lead l=new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		model.addAttribute("msg", "Lead Saved Successfully!!");
//		leadService.saveLead(l);
//		return "create_lead";
//	}
	 
	 @RequestMapping("/listall")
	 public String getAllLeads(ModelMap model)
	 {
		 List<Lead> leads=leadService.getLeads();
		 model.addAttribute("leads", leads);
		 
		 return "lead_search_result";
		 
	 }
	 @RequestMapping("/delete")
	 public String deleteById(@RequestParam("id")Long id,ModelMap model)
	 {
		 
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		 return "lead_search_result";
	 }
	 @RequestMapping("/update")
	 public String updateOneLead(@RequestParam("id") Long id,ModelMap model)
	 {
		 Lead leads=leadService.findOneLead(id);
		 model.addAttribute("leads", leads);
		 
		 return "update_lead";
	 }
	 @RequestMapping("/updateLead")
	 public String updateLead(@ModelAttribute("leads")Lead leads,ModelMap model)
	 {
		 leadService.saveLead(leads);
		 model.addAttribute("msg", "Lead with id:"+leads.getId()+"saved");
		 List<Lead> lead=leadService.getLeads();
		 model.addAttribute("leads", lead);
		 
		 return "lead_search_result";
		 
		 
		
	 }
}
