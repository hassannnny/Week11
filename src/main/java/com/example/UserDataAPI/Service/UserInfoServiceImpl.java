package com.example.UserDataAPI.Service;

import com.example.UserDataAPI.Dao.UserDao;
import com.example.UserDataAPI.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserInfoServiceImpl implements UserInfoService{
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

    //@Override
    //    public UserInfo authenticateUser(String username, String password){
    //           for(UserInfo user:userDao.findAll()){
    //               if(user.getPassword().equals(password)&&user.getUsername().equals(username))
    //                   return user;
    //           }
    //           return null;
    //    }

    @Override
    public UserInfo setUser(UserInfo user) {
        return userDao.save(user);
    }

    @Override
    public String deleteUserByID(int id) {
        userDao.deleteById(id);
        return "Deleted user #"+id+" successfully.";
    }
}
