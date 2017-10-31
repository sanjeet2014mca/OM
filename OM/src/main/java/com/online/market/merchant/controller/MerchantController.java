package com.online.market.merchant.controller;

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
import com.online.market.merchant.service.MerchantService;
import com.online.market.merhcnat.entity.MerchantRegistration;
import com.online.market.user.controller.UserRegisterationController;
import com.online.market.utility.MessageConstraints;
import com.online.market.utility.RandomString;
import com.online.market.utility.ReponseWrapper;
@RestController
public class MerchantController {
	private static final Logger logger = Logger.getLogger(UserRegisterationController.class);
	@Autowired   																															
	private MerchantService merchantService;
	@SuppressWarnings({ "static-access" })
	@RequestMapping(value = "/createMerchant",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper createMerchant(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/createMerchant/?data={name:sanjeet,contactEmail:test3@gmail.com,mobileNo:9066740253,Password:password,pan:ATRPM4423M,contactName:sanjeet,createdBy:Chandan}
		logger.getLogger("createMerchant---------------->start");
		ReponseWrapper result =new ReponseWrapper();
		try{
			String data = request.getParameter("data");
			MerchantRegistration merchantRegistration=new MerchantRegistration();
			merchantRegistration = new Gson().fromJson(data, MerchantRegistration.class);
			int userCount=merchantService.merchantExist(merchantRegistration.getMobileNo());
			if(userCount<=0)
			{
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//password encryption
				String hashedPassword = passwordEncoder.encode(merchantRegistration.getPassword());
				merchantRegistration.setPassword(hashedPassword);
				merchantRegistration.setActive(true);
				merchantRegistration.setUserType("Merchant");
				RandomString defaultPass = new RandomString();
				String randomPass=defaultPass.nextString();
				merchantRegistration.setDefaultPassword(randomPass);
				boolean status = merchantService.submitRegistration(merchantRegistration);
				if (status==true){
					result.setErrorCode(MessageConstraints.Error.MERCHANTREGISTER.getCode());
					result.setErrorMessage(MessageConstraints.Error.MERCHANTREGISTER.getDescription());
					System.out.println(result.toString());
				}
			}else
			{
				result.setErrorCode(MessageConstraints.Error.DUPLICATEMERCHANT.getCode());
				result.setErrorMessage(MessageConstraints.Error.DUPLICATEMERCHANT.getDescription());
				System.out.println(result.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("createMerchant---------------->end");
		return result;	
	}	

	//merchant update method ,Note:disable required contents send mob no for fetch records
	@RequestMapping(value = "/editMerProfile",method=RequestMethod.GET)
	public @ResponseBody MerchantRegistration merchantProfile(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/editMerProfile/?data={mobileNo:9066740253}
		logger.info("updateProfile---------------->start");
		String data = request.getParameter("data");
		MerchantRegistration merchantRegistration=new MerchantRegistration();
		MerchantRegistration merchantRegistrationDetails=null;
		try{
			merchantRegistration = new Gson().fromJson(data, MerchantRegistration.class);
			merchantRegistrationDetails=merchantService.merchantDetails(merchantRegistration.getMobileNo());
			if(merchantRegistrationDetails!=null)
			{
				merchantRegistrationDetails.setErrorCode(MessageConstraints.Error.MERCHANTDETAILS.getCode());
				merchantRegistrationDetails.setErrorDesc(MessageConstraints.Error.MERCHANTDETAILS.getDescription());
				return merchantRegistrationDetails;
			}else
			{
				merchantRegistrationDetails=new MerchantRegistration();
				merchantRegistrationDetails.setErrorCode(MessageConstraints.Error.MERCHANTNOTEXISTS.getCode());
				merchantRegistrationDetails.setErrorDesc(MessageConstraints.Error.MERCHANTNOTEXISTS.getDescription());
				return merchantRegistrationDetails;	
			}
		}catch(Exception e){
			e.printStackTrace();
			merchantRegistrationDetails.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
			merchantRegistrationDetails.setErrorDesc(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
		}
		logger.info("updateProfile---------------->end");
		return merchantRegistrationDetails;	
	}	
	//customer save update method Note:mobile will  from editProfile cookies
	@RequestMapping(value = "/saveUpdateMerchant",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper saveUpdateMerchantr(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/saveUpdateMerchant/?data={name:sanju,pan:TTM4423M,contactEmail:MErchant55@gmail.com,mobileNo:9066740258,pin:845109}
		logger.info("saveUpdateMerchantr---------------->start");
		String data = request.getParameter("data");
		ReponseWrapper result =new ReponseWrapper();
		boolean merchantUpdateStatus=false;
		try{
			merchantUpdateStatus=merchantService.updateMerchantDetails(data);
			if(merchantUpdateStatus==true)
			{
				result.setErrorCode(MessageConstraints.Error.MERCHANTUPDATEDSUCCESSFULLY.getCode());
				result.setErrorMessage(MessageConstraints.Error.MERCHANTUPDATEDSUCCESSFULLY.getDescription());
				return result;
			}else
			{
				result.setErrorCode(MessageConstraints.Error.MERCHANTNOTUPDATED.getCode());
				result.setErrorMessage(MessageConstraints.Error.MERCHANTNOTUPDATED.getDescription());
				return result;	
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setErrorCode(MessageConstraints.Error.INTERNALSERVERERROR.getCode());
			result.setErrorMessage(MessageConstraints.Error.INTERNALSERVERERROR.getDescription());
		}
		logger.info("saveUpdateMerchantr---------------->end");
		return result;	
	}	
	//Change password 
	@RequestMapping(value = "/updateMerchantPassword",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper updatePassword(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/updateMerchantPassword/?data={mobileNo:9066740258,Password:password1,DefaultPassword:password1}
		logger.info("merchant updatePassword---------------->start");
		String data = request.getParameter("data");
		ReponseWrapper result =new ReponseWrapper();
		boolean merchantUpdateStatus=false;
		try{
			merchantUpdateStatus=merchantService.updatePassword(data);
			if(merchantUpdateStatus==true)
			{
				result.setErrorCode(MessageConstraints.Error.PASSWORDMERCHANTUPDATEDSUCCESSFULLY.getCode());
				result.setErrorMessage(MessageConstraints.Error.PASSWORDMERCHANTUPDATEDSUCCESSFULLY.getDescription());
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
		logger.info("merchant updatePassword---------------->end");
		return result;	
	}	
	
	
	
	
	

}