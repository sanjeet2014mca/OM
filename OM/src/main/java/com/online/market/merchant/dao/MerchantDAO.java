package com.online.market.merchant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.market.merhcnat.entity.MerchantRegistration;

@Repository("merchantDAO")
public interface MerchantDAO extends JpaRepository<MerchantRegistration, Integer> {
	@Query("select count(*) from MerchantRegistration where MobileNo = ? and isActive = 1")
	public int merchantExist(String MobileNo);
	@Query("from MerchantRegistration where MobileNo = ? and isActive = 1")
	public MerchantRegistration merchantDetails(String MobileNo);	
}

	
