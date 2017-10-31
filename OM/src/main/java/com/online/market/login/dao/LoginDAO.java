package com.online.market.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.market.login.entity.LoginEntity;
@Repository("loginDAO")
public interface LoginDAO extends JpaRepository<LoginEntity, Integer> {
	@Query("from LoginEntity where MobileNo = ? and isActive = 1")
	public LoginEntity loginDetails(String MobileNo);	
}
