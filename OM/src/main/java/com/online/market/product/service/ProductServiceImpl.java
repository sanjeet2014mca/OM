package com.online.market.product.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.market.merchant.dao.MerchantDAO;
import com.online.market.merhcnat.entity.MerchantRegistration;
import com.online.market.product.dao.ProductDao;
import com.online.market.product.entity.ProductDetails;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductDao productDao;
	@Autowired
	MerchantDAO merchantDao;
	public boolean submitProductDetails(ProductDetails productDetails) {
		logger.info("submitProductDetails---------------->start");
		MerchantRegistration merchantRegistration=null;
		boolean status=false;
		merchantRegistration=merchantDao.merchantDetails(productDetails.getMerchantMob());
		if(merchantRegistration!=null){
			productDetails.setMerchantId(merchantRegistration.getId());
			productDetails.setMerchantMob(merchantRegistration.getMobileNo());
			productDao.saveAndFlush(productDetails);
			status=true;
		}
			logger.info("submitProductDetails---------------->end");	
			return status;

		}

	}
