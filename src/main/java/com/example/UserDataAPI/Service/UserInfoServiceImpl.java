package com.example.UserDataAPI.Service;

import com.example.UserDataAPI.Dao.UserDao;
import com.example.UserDataAPI.Entity.UserFinder;
import com.example.UserDataAPI.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService, UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserInfo> getUsers() {
        return userDao.findAll();
    }

    @Override
    public UserInfo addUser(UserInfo user) {
        return userDao.save(user);
    }

    @Override
    public UserInfo getUserByID(int id) {
        return userDao.getReferenceById(id);
    }

    @Override
    public String getUsername(String password) {
        return userDao.getUsername(password);
    }

    @Override
    public UserInfo setUser(UserInfo user) {
        return userDao.save(user);
    }

    @Override
    public String deleteUserByID(int id) {
        userDao.deleteById(id);
        return "Deleted user #"+id+" successfully.";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userDao.getUserByUsername(username);
        if(userInfo==null){
            throw new UsernameNotFoundException("We could not find any accounts linked with that username.");
        }
        return new UserFinder(userInfo);
    }
}
