package com.online.market.merchant.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.online.market.merchant.dao.MerchantDAO;
import com.online.market.merhcnat.entity.MerchantRegistration;
@Component("merchantService	")
public class MerchantRegisterImpl implements MerchantService {
	public Logger logger=Logger.getLogger(MerchantRegisterImpl.class);
	@Autowired
	MerchantDAO merchantDao;
	public boolean submitRegistration(MerchantRegistration merchantRegistration) {
		boolean status=false;
		if((merchantRegistration.getMobileNo()!=null)&&(merchantRegistration.getContactEmail()!=null)){
			merchantDao.saveAndFlush(merchantRegistration);
			status=true;
		}
		return status;
	}
	@Override
	public int merchantExist(String mobileNO) {
		logger.info("merchantExist---------------->start");
		int userCount=merchantDao.merchantExist(mobileNO);
		logger.info("merchantExist---------------->end");
		return userCount;
	}
	@Override
	public MerchantRegistration merchantDetails(String mobileNO) {
		MerchantRegistration merchantRegistration=null;
		try{
			logger.info("merchantDetails---------------->start");
			merchantRegistration=merchantDao.merchantDetails(mobileNO);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("merchantDetails---------------->end");
		return merchantRegistration;
	}
	@Override
	public boolean updateMerchantDetails(String jsonData) {
		logger.info("updateUserDetails---------------->start");
		MerchantRegistration merchantRegistrationDetails=null;
		boolean status=false;
		try{
			MerchantRegistration merchantRegistration=new MerchantRegistration();
			merchantRegistration = new Gson().fromJson(jsonData, MerchantRegistration.class);
			merchantRegistrationDetails=merchantDao.merchantDetails(merchantRegistration.getMobileNo());
			merchantRegistrationDetails.setContactEmail(merchantRegistration.getContactEmail()!=null?merchantRegistration.getContactEmail():"OM@gmail.com");
			merchantRegistrationDetails.setPan(merchantRegistration.getPan()!=null?merchantRegistration.getPan():"OMOMOMOMOM");
			merchantRegistrationDetails.setName(merchantRegistration.getName()!=null?merchantRegistration.getName():"OM");
			merchantRegistrationDetails.setPin(merchantRegistration.getPin()!=null?merchantRegistration.getPin():"845106");
			merchantRegistrationDetails.setPermanentAddress(merchantRegistration.getPermanentAddress()!=null?merchantRegistration.getPermanentAddress():"OM");
			merchantDao.saveAndFlush(merchantRegistrationDetails);
			status= true;
			logger.info("updateUserDetails---------------->end");
		}catch(Exception e){
			e.printStackTrace();
			status= false;
		}
		return status;


	}
	@Override
	public boolean updatePassword(String jsonData) {
		logger.info("merchant updatePassword---------------->start");
		MerchantRegistration merchantRegistrationDetails=null;
		boolean status=false;
		try{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//password encryption
			MerchantRegistration merchantRegistration=new MerchantRegistration();
			merchantRegistration = new Gson().fromJson(jsonData, MerchantRegistration.class);
			merchantRegistrationDetails=merchantDao.merchantDetails(merchantRegistration.getMobileNo());
			if(merchantRegistrationDetails!=null){
				merchantRegistrationDetails.setPassword(passwordEncoder.encode(merchantRegistration.getPassword()));
				merchantRegistrationDetails.setDefaultPassword(merchantRegistration.getDefaultPassword());
				merchantDao.saveAndFlush(merchantRegistrationDetails);
				status= true;
			}
			logger.info("merhant updatePassword---------------->end");
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

}



