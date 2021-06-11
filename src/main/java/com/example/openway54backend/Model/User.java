package com.example.openway54backend.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private String username;
    private String email;
    private String userpassword;
    private boolean adminstate;

    public void hashUserPassword(String pass){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.userpassword = passwordEncoder.encode(pass);
    }

    @Override
    public String toString() {
        return "{" +
                "\"Name\":\""+ this.username+"\","+
                "\"Email\":\""+ this.email+"\""+
                "}";
    }
}
