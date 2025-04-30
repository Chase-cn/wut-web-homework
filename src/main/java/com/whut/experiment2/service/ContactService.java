package com.whut.experiment2.service;

import com.whut.experiment2.model.Contact;
import java.util.List;

public interface ContactService {
    // 添加联系人
    Contact addContact(Contact contact);

    // 修改联系人
    Contact updateContact(Long id, Contact contact);

    // 删除联系人
    boolean deleteContact(Long id);

    // 获取所有联系人
    List<Contact> getAllContacts();

    // 根据ID获取联系人
    Contact getContactById(Long id);
}