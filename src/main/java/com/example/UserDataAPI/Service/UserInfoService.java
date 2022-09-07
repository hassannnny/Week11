package com.example.UserDataAPI.Service;

import com.example.UserDataAPI.Entity.UserInfo;

import java.util.List;

public interface UserInfoService {
List<UserInfo> getUsers();
UserInfo addUser(UserInfo user);
UserInfo getUserByID(int id);
UserInfo setUser(UserInfo user);
String deleteUserByID(int id);
}
