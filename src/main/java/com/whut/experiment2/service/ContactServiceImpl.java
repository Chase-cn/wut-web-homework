package com.whut.experiment2.service;

import com.whut.experiment2.exception.ContactNotFoundException;
import com.whut.experiment2.mapper.ContactMapper;
import com.whut.experiment2.model.Contact;
import com.whut.experiment2.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;

    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public Contact addContact(Contact contact) {
        contactMapper.insertContact(contact);
        return contact;
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact targetContact = contactMapper.selectContactById(id);
        if (targetContact == null) {
            throw new ContactNotFoundException(id);
        } else {
            contact.setId(id);
            contactMapper.updateContact(contact);
            return contact;
        }
    }

    @Override
    public boolean deleteContact(Long id) {
        int affectedRows=contactMapper.deleteContact(id);
        if(affectedRows==0){
            throw new ContactNotFoundException(id);
        }
        else{
            return true;
        }

    }

    @Override
    public List<Contact> getAllContacts() {
        return contactMapper.selectAllContacts();
    }

    @Override
    public Contact getContactById(Long id) {
       Contact contact=contactMapper.selectContactById(id);
       if(contact==null){
           throw new ContactNotFoundException(id);
       }
       else{
           return contact;
       }
    }
}
