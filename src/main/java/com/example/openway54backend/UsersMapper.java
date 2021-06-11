package com.example.openway54backend;

import com.example.openway54backend.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Insert("insert into openwayusers (username,email,userpassword) values(#{username},#{email},#{userpassword})")
    void addRegion(User user);

    @Select("select * from openwayusers where email=#{email}")
    User getUserForEmail(String email);

    @Select("select * from openwayusers")
    List<User> getAllUsers();

}
