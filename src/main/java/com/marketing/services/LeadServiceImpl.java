package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.Leadrepository;
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private Leadrepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getLeads() {
		List<Lead> leads=leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteOneLead(Long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findOneLead(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead=findById.get();
		return lead;
	}

	

}
