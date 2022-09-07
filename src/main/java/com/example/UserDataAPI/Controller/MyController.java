package com.example.UserDataAPI.Controller;

import com.example.UserDataAPI.Entity.UserInfo;
import com.example.UserDataAPI.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/userService")
    public List<UserInfo> getUsers(){
        return this.userInfoService.getUsers();
    }
    @GetMapping("/userService/{id}")
    public UserInfo getUserByID(@PathVariable int id){
        return this.userInfoService.getUserByID(id);
    }
    @PostMapping("/userService")
    public UserInfo addUser(@RequestBody UserInfo user){
        return this.userInfoService.addUser(user);
    }
    @PutMapping("/userService")
    public UserInfo setUser(@RequestBody UserInfo user){
        return this.userInfoService.setUser(user);
    }
    @DeleteMapping("/userService/{id}")
    public String deleteUserByID(@PathVariable int id){
        return this.userInfoService.deleteUserByID(id);
    }
}
