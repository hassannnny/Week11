package com.example.UserDataAPI.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_info")
public class UserInfo {
    public long getCart() {
        return cart;
    }

    public void setCart(long cart) {
        this.cart = cart;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String password;
    @Column(unique=true)
    private String email;
    @Column
    private String name;
    @Column
    private double balance=0.0;
    @Column
    private long cart;
    @Column
    private Roles roles;

    public UserInfo(){

    }
    public UserInfo(int id,String username, String password,String name,String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email=email;
        this.name=name;
        this.balance=0.0;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }
}
