package com.example.UserDataAPI.Filter;

import com.example.UserDataAPI.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter {
    @Autowired
    private UserDao userDao;
}
