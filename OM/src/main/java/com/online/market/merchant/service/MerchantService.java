package com.online.market.merchant.service;

import com.online.market.merhcnat.entity.MerchantRegistration;

public interface MerchantService {
	public int merchantExist(String mobile);
	public boolean submitRegistration(MerchantRegistration merchantRegistration) ;
	public MerchantRegistration merchantDetails(String mobileNO) ;
	public boolean updateMerchantDetails(String jsonData);
	public boolean updatePassword(String jsonData);
}
