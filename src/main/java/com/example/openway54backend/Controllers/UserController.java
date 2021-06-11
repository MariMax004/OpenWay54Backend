package com.example.openway54backend.Controllers;

import com.example.openway54backend.DataBaseWorkers.Worker;
import com.example.openway54backend.Model.User;
import com.example.openway54backend.UsersMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    Worker worker;

    UserController(UsersMapper usersMapper){
        worker = new Worker(usersMapper);
    }


    @RequestMapping(value = "user/worker/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user){
        try {
            user.hashUserPassword(user.getUserpassword());
            worker.addUser(user);
            return new ResponseEntity<>("Успешно", HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>("Такой пользователь уже существует", HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "user/worker/auth", method = RequestMethod.POST)
    public ResponseEntity authUser(@RequestBody User user){
        if(worker.authUser(user)){
            if(worker.isAdmin(user)){
                return new ResponseEntity<>("Успешно,админ", HttpStatus.OK);
            }

            return new ResponseEntity<>("Успешно,пользователь", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Невернй логин или пароль", HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "user/worker/getUsers", method = RequestMethod.GET)
    public String getUsers(){
        return String.valueOf(worker.getAllUsers());
    }

}
