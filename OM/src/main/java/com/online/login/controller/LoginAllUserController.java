package com.online.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.online.market.login.entity.LoginEntity;
import com.online.market.login.service.LoginService;
import com.online.market.utility.MessageConstraints;
@RestController
public class LoginAllUserController {
	private static final Logger logger = Logger.getLogger(LoginAllUserController.class);
	@Autowired 
	private LoginService loginService;
	//customer login method, discussed about flag
	@RequestMapping(value = "/loginUser",method=RequestMethod.GET)
	public @ResponseBody LoginEntity loginUser(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/loginUser/?data={mobileNo:9066740254,Password:password1}
		logger.info("loginUser---------------->start");
		String data = request.getParameter("data");
		LoginEntity loginEntity=new LoginEntity();
		LoginEntity loginEntityDetails=null;
		boolean matches=false;
		try{
			loginEntity = new Gson().fromJson(data, LoginEntity.class);
			loginEntityDetails=loginService.loginDetails(loginEntity.getMobileNo());
			if(loginEntityDetails!=null)
			{
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//password encryption
				matches = passwordEncoder.matches(loginEntity.getPassword(), loginEntityDetails.getPassword());
				if(matches==true){
					loginEntityDetails.setErrorCode(MessageConstraints.Error.USERLOGINSUCCESSFULLY.getCode());
					loginEntityDetails.setErrorDesc(MessageConstraints.Error.USERLOGINSUCCESSFULLY.getDescription());
					return loginEntityDetails;
				}else{
					loginEntityDetails=new LoginEntity();
					loginEntityDetails.setErrorCode(MessageConstraints.Error.INVALIDPASSWORD.getCode());
					loginEntityDetails.setErrorDesc(MessageConstraints.Error.INVALIDPASSWORD.getDescription());
					return loginEntityDetails;
				}
			}else
			{
				loginEntity.setErrorCode(MessageConstraints.Error.INVALIDPASSWORD.getCode());
				loginEntity.setErrorDesc(MessageConstraints.Error.INVALIDPASSWORD.getDescription());
				return loginEntity;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		logger.info("loginUser---------------->start");
		return loginEntity;
	}
}
