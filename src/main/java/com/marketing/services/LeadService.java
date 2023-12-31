package com.marketing.services;


import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService 
{
	public void saveOneLead(Lead l);

	public List<Lead> listAllLeads();

	public void deleteOneLead(long id);

	public Lead getById(long id);
}
