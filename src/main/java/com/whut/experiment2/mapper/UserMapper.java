package com.whut.experiment2.mapper;

import com.whut.experiment2.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insert(User user);
    User findByName(String name);
    User findById(Integer id);
    int updatePassword(@Param("id") Integer id,
                       @Param("oldPassword") String oldPassword,
                       @Param("newPassword") String newPassword);
}