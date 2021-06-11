package com.example.openway54backend.DataBaseWorkers;

import com.example.openway54backend.Model.User;
import com.example.openway54backend.UsersMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private final UsersMapper usersMapper;

    public Worker(UsersMapper usersMapper){
        this.usersMapper = usersMapper;
    }

    public void addUser(User user) throws Exception{
        usersMapper.addRegion(user);
    }

    public boolean authUser(User user) {
        User dbUser = usersMapper.getUserForEmail(user.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(user.getUserpassword(),dbUser.getUserpassword());
    }

    public boolean isAdmin(User user){
        return usersMapper.getUserForEmail(user.getEmail()).isAdminstate();
    }

    public ArrayList<String> getAllUsers(){
        ArrayList<String> out = new ArrayList<String>();
        out.stream();
        for(User el: usersMapper.getAllUsers()) {
            if (!el.isAdminstate()) {
                out.add(el.toString());
            }
        }
        if(out == null) {
            out.add("Нет пользователей");
        }

        return out;
    }
}
