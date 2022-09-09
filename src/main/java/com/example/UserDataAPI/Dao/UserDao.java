package com.example.UserDataAPI.Dao;

import com.example.UserDataAPI.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<UserInfo,Integer> {
    @Query(value = "Select username from user_info where password =:password", nativeQuery = true)
    String getUsername(String password);
}
