package com.example.UserDataAPI.Dao;

import com.example.UserDataAPI.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserInfo,Integer> {
}
