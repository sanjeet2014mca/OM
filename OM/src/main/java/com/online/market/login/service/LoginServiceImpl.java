package com.online.market.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.market.login.dao.LoginDAO;
import com.online.market.login.entity.LoginEntity;
@Component("loginService")
public class LoginServiceImpl  implements LoginService{
	public Logger logger=Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	LoginDAO loginDAO;
	@Override
	public LoginEntity loginDetails(String mobileNO) {
		LoginEntity loginDetails=null;
		try{
			logger.info("userExist---------------->start");
			loginDetails=loginDAO.loginDetails(mobileNO);
			logger.info("userExist---------------->end");
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDetails;
	}
}


