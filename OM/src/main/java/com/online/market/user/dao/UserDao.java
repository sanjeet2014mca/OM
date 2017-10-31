package com.online.market.user.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.market.user.entity.UserRegistration;


@Repository("UserDao")
public interface UserDao extends JpaRepository<UserRegistration, Integer> {
@Query("select count(*) from UserRegistration where MobileNo = ? and isActive = 1")
public int userExist(String MobileNo);
@Query("from UserRegistration where MobileNo = ? and isActive = 1")
public UserRegistration userDetails(String MobileNo);	
}
