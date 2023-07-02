package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entities.Contact;

public interface ContactService
{
	public void saveContact(Contact contact);


	public List<Contact> getAllContacts();


	public Contact findById(long id);


	public Contact getContactById(long id);
}
