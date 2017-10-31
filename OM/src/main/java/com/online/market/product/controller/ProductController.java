package com.online.market.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.online.market.product.entity.ProductDetails;
import com.online.market.product.service.ProductService;
import com.online.market.user.controller.UserRegisterationController;
import com.online.market.utility.MessageConstraints;
import com.online.market.utility.ReponseWrapper;

@RestController
public class ProductController {
	private static final Logger logger = Logger.getLogger(UserRegisterationController.class);
	@Autowired 
	ProductService productService;
	@RequestMapping(value = "/insertProduct",method=RequestMethod.GET)
	public @ResponseBody ReponseWrapper insertProduct(HttpServletRequest request,HttpServletResponse response){
		//http://localhost:8088/insertProduct/?data={product_id:iioooo0prtyX06,taxable:12,weight:1kg,image:0X00000000GFT67TYY,price:1000,brand:ETA,merchantMob:9066740254}
		logger.info("insertProduct---------------->start");
		ReponseWrapper result =new ReponseWrapper();
		try{
			String data = request.getParameter("data");
			ProductDetails productDetails=new ProductDetails();
			productDetails = new Gson().fromJson(data, ProductDetails.class);
			boolean status = productService.submitProductDetails(productDetails);
			if (status==true){
				result.setErrorCode(MessageConstraints.Error.PRODUCTINSERTEDSUCCESSFULLY.getCode());
				result.setErrorMessage(MessageConstraints.Error.PRODUCTINSERTEDSUCCESSFULLY.getDescription());
				System.out.println(result.toString());
			}else
			{
				result.setErrorCode(MessageConstraints.Error.PRODUCTINSERTFAILED.getCode());
				result.setErrorMessage(MessageConstraints.Error.PRODUCTINSERTFAILED.getDescription());
				System.out.println(result.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("createUser---------------->end");
		return result;	
	}	
}
