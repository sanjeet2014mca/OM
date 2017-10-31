package com.online.market.user.controller;

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
import com.online.market.user.entity.UserRegistration;
import com.online.market.user.service.UserService;
import com.online.market.utility.MessageConstraints;
import com.online.market.utility.RandomString;
import com.online.market.utility.ReponseWrapper;
@RestController
public class UserRegisterationController {
	private static final Logger logger = Logger.getLogger(UserRegisterationController.class);
	@Autowired 
	private UserService userService;
	
	//customer creation method
	@RequestMapping(value = "/createUser",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper createUser(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/createUser/?data={name:sanjeet,contactEmail:test3@gmail.com,mobileNo:9066740258,pan:ATRPM4423M,Password:password}
		logger.info("createUser---------------->start");
		System.out.println("createUser");
		ReponseWrapper result =new ReponseWrapper();
		try{
			String data = request.getParameter("data");
			UserRegistration userRegistration=new UserRegistration();
			userRegistration = new Gson().fromJson(data, UserRegistration.class);
			int userCount=userService.userExist(userRegistration.getMobileNo());
			if(userCount<=0)
			{
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//password encryption
				String hashedPassword = passwordEncoder.encode(userRegistration.getPassword());
				userRegistration.setPassword(hashedPassword);
				userRegistration.setActive(true);
				userRegistration.setUserType("Customer");
				RandomString defaultPass = new RandomString();
				String randomPass=defaultPass.nextString();
				userRegistration.setDefaultPassword(randomPass);
				boolean status = userService.submitRegistration(userRegistration);
				if (status==true){
					result.setErrorCode(MessageConstraints.Error.USERREGISTER.getCode());
					result.setErrorMessage(MessageConstraints.Error.USERREGISTER.getDescription());
					System.out.println(result.toString());
				}
			}else
			{
				result.setErrorCode(MessageConstraints.Error.DUPLICATEUSER.getCode());
				result.setErrorMessage(MessageConstraints.Error.DUPLICATEUSER.getDescription());
				System.out.println(result.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("createUser---------------->end");
		return result;	
	}	
	//customer update method ,Note:disable required contents send mob no for fetch records
	@RequestMapping(value = "/editProfile",method=RequestMethod.GET)
	public @ResponseBody UserRegistration updateProfile(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/editUser/?data={mobileNo:9066740253}
		logger.info("updateProfile---------------->start");
		String data = request.getParameter("data");
		UserRegistration userRegistration=new UserRegistration();
		UserRegistration userRegistrationDetails=null;
		try{
			userRegistration = new Gson().fromJson(data, UserRegistration.class);
			userRegistrationDetails=userService.userDetails(userRegistration.getMobileNo());
			if(userRegistrationDetails!=null)
			{
				userRegistrationDetails.setErrorCode(MessageConstraints.Error.USERDETAILS.getCode());
				userRegistrationDetails.setErrorDesc(MessageConstraints.Error.USERDETAILS.getDescription());
				return userRegistrationDetails;
			}else
			{
				userRegistrationDetails=new UserRegistration();
				userRegistrationDetails.setErrorCode(MessageConstraints.Error.USERNOTEXISTS.getCode());
				userRegistrationDetails.setErrorDesc(MessageConstraints.Error.USERNOTEXISTS.getDescription());
				return userRegistrationDetails;	
			}
		}catch(Exception e){
			e.printStackTrace();
			userRegistrationDetails.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
			userRegistrationDetails.setErrorDesc(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
		}
		logger.info("updateProfile---------------->end");
		return userRegistrationDetails;	
	}	
	//customer save update method Note:mobile will  from editProfile cookies
	@RequestMapping(value = "/saveUpdateUser",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper saveUpdateUser(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/saveUpdateUser/?data={name:sanju,pan:TTM4423M,contactEmail:test55@gmail.com,mobileNo:9066740258,pin:845109}
		logger.info("saveUpdateUser---------------->start");
		String data = request.getParameter("data");
		ReponseWrapper result =new ReponseWrapper();
		@SuppressWarnings("unused")
		boolean userUpdateStatus=false;
		try{
			userUpdateStatus=userService.updateUserDetails(data);
			if(userUpdateStatus=true)
			{
				result.setErrorCode(MessageConstraints.Error.USERUPDATEDSUCCESSFULLY.getCode());
				result.setErrorMessage(MessageConstraints.Error.USERUPDATEDSUCCESSFULLY.getDescription());
				return result;
			}else
			{
				result.setErrorCode(MessageConstraints.Error.USERNOTUPDATED.getCode());
				result.setErrorMessage(MessageConstraints.Error.USERNOTUPDATED.getDescription());
				return result;	
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
			result.setErrorMessage(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
		}
		logger.info("saveUpdateUser---------------->end");
		return result;	
	}	
	//Change password 
	@RequestMapping(value = "/updatePassword",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper updatePassword(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/updatePassword/?data={mobileNo:9066740258,Password:password1,DefaultPassword:password1}
		logger.info("updatePassword---------------->start");
		String data = request.getParameter("data");
		ReponseWrapper result =new ReponseWrapper();
		boolean userUpdateStatus=false;
		try{
			userUpdateStatus=userService.updatePassword(data);
			if(userUpdateStatus==true)
			{
				result.setErrorCode(MessageConstraints.Error.PASSWORDUSERUPDATEDSUCCESSFULLY.getCode());
				result.setErrorMessage(MessageConstraints.Error.PASSWORDUSERUPDATEDSUCCESSFULLY.getDescription());
				return result;
			}else
			{
				result.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
				result.setErrorMessage(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
				return result;	
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
			result.setErrorMessage(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
		}
		logger.info("updatePassword---------------->end");
		return result;	
	}	


}