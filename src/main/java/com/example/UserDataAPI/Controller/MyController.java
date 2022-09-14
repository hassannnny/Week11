package com.example.UserDataAPI.Controller;

import com.example.UserDataAPI.Entity.UserInfo;
import com.example.UserDataAPI.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins="https://localhost:3000")
@RestController
public class MyController {
    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name","Dijon");
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/userService")
    public List<UserInfo> getUsers(){
        return this.userInfoService.getUsers();
    }
    @GetMapping("/userService/{id}")
    public UserInfo getUserByID(@PathVariable int id){
        return this.userInfoService.getUserByID(id);
    }

    @GetMapping("/{password}")
    public String getUsername(@PathVariable String password){
        return this.userInfoService.getUsername(password);
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
