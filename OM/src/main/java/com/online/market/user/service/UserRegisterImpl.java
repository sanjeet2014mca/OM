package com.online.market.user.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.online.market.user.dao.UserDao;
import com.online.market.user.entity.UserRegistration;

@Component("userService	")
public class UserRegisterImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserRegisterImpl.class);
	@Autowired
	UserDao userDao;
	public boolean submitRegistration(UserRegistration userRegistration) {
		logger.info("submitRegistration---------------->start");
		boolean status=false;
		if((userRegistration.getMobileNo()!=null)&&(userRegistration.getContactEmail()!=null)){
			userDao.saveAndFlush(userRegistration);
			status=true;
		}
		logger.info("submitRegistration---------------->end");	
		return status;
	}
	public int userExist(String mobileNO) {
		logger.info("userExist---------------->start");
		int userCount=userDao.userExist(mobileNO);
		logger.info("userExist---------------->end");
		return userCount;
	}

	public UserRegistration userDetails(String mobileNO) {
		logger.info("userExist---------------->start");
		UserRegistration userRegistrationDetails=userDao.userDetails(mobileNO);
		logger.info("userExist---------------->end");
		return userRegistrationDetails;
	}

	public boolean updateUserDetails(String jsonData) {
		logger.info("updateUserDetails---------------->start");
		UserRegistration userRegistrationDetails=null;
		boolean status=false;
		try{
			UserRegistration userRegistration=new UserRegistration();
			userRegistration = new Gson().fromJson(jsonData, UserRegistration.class);
			userRegistrationDetails=userDao.userDetails(userRegistration.getMobileNo());
			userRegistrationDetails.setContactEmail(userRegistration.getContactEmail()!=null?userRegistration.getContactEmail():"OM@gmail.com");
			userRegistrationDetails.setPan(userRegistration.getPan()!=null?userRegistration.getPan():"OMOMOMOMOM");
			userRegistrationDetails.setName(userRegistration.getName()!=null?userRegistration.getName():"OM");
			userRegistrationDetails.setPin(userRegistration.getPin()!=null?userRegistration.getPin():"845106");
			userRegistrationDetails.setPermanentAddress(userRegistration.getPermanentAddress()!=null?userRegistration.getPermanentAddress():"OM");
			userDao.saveAndFlush(userRegistrationDetails);
			status= true;
			logger.info("updateUserDetails---------------->end");
		}catch(Exception e){
			e.printStackTrace();
			status= false;
		}
		return status;
	}
	public boolean updatePassword(String jsonData) {
		logger.info("updatePassword---------------->start");
		UserRegistration userRegistrationDetails=null;
		boolean status=false;
		try{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//password encryption
			UserRegistration userRegistration=new UserRegistration();
			userRegistration = new Gson().fromJson(jsonData, UserRegistration.class);
			userRegistrationDetails=userDao.userDetails(userRegistration.getMobileNo());
			if(userRegistrationDetails!=null){
				userRegistrationDetails.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
				userRegistrationDetails.setDefaultPassword(userRegistration.getDefaultPassword());
				userDao.saveAndFlush(userRegistrationDetails);
				status= true;
			}
			logger.info("updatePassword---------------->end");
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}


}


