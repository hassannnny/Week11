package com.example.UserDataAPI.Entity;

import javax.persistence.*;

@Entity
@Table(name="userinfo")
public class UserInfo {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
    @Column
    private String username;
    @Column
    private String password;
    public UserInfo(){

    }
    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
