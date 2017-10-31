package com.online.market.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.market.product.entity.ProductDetails;

@Repository("productDao")
public interface ProductDao extends JpaRepository<ProductDetails, Integer> {
	
}