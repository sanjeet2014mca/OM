package com.online.market.user.service;

import com.online.market.user.entity.UserRegistration;

public interface UserService {
	public boolean submitRegistration(UserRegistration registrationForm) ;
	public int userExist(String mobileNO);
	public UserRegistration userDetails(String mobileNO);
	public boolean updateUserDetails(String jsonData);
	public boolean updatePassword(String jsonData);
}
