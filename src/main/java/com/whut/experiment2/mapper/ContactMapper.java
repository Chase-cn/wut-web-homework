package com.whut.experiment2.mapper;

import com.whut.experiment2.model.Contact;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ContactMapper {
    // 添加联系人
    int insertContact(Contact contact);

    // 修改联系人
    int updateContact(Contact contact);

    // 删除联系人
    int deleteContact(Long id);

    // 查询所有联系人
    List<Contact> selectAllContacts();

    // 根据ID查询联系人
    Contact selectContactById(Long id);
}
