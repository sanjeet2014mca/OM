package com.online.market.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
@Entity
@Table(name = "ProductDetails")
public class ProductDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	@Column(name = "product_id")
	private String product_id;
	@Column(name = "merchantId")
	private Integer merchantId;
	@Column(name = "merchantMob")
	private String merchantMob;
	@Column(name = "taxable")
	private String taxable;
	@Column(name = "inventory_policy")
	private String inventory_policy;
	@Column(name = "position")
	private String position;
	@Column(name = "weight")
	private String weight;
	@Column(name = "barcode")
	private String barcode;
	@Column(name = "image")
	private String image;
	@Column(name = "weight_unit")
	private String weight_unit;
	@Column(name = "sku")
	private String sku;
	@Column(name = "fulfillment_service")
	private String fulfillment_service;
	@Column(name = "image_id")
	private  Boolean image_id;
	@Column(name = "option1")
	private String option1;
	@Column(name = "option2")
	private String option2;
	@Column(name = "option3")
	private String option3;
	@Column(name = "title")
	private String title;
	@Column(name = "updated_at")
	private String updated_at;
	@Column(name = "price")
	private String price;
	@Column(name = "requires_shipping")
	private String requires_shipping;
	@Column(name = "old_inventory_quantity")
	private String old_inventory_quantity;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "grams")
	private String grams;
	@Column(name = "inventory_management")
	private String inventory_management;
	@Column(name = "compare_at_price")
	private String compare_at_price;
	@Column(name = "inventory_quantity")
	private String inventory_quantity;
	@Column(name = "brand")
	private String brand;
	@Column(name = "status")
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantMob() {
		return merchantMob;
	}

	public void setMerchantMob(String merchantMob) {
		this.merchantMob = merchantMob;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getImage_id() {
		return image_id;
	}

	public void setImage_id(Boolean image_id) {
		this.image_id = image_id;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getCompare_at_price() {
		return compare_at_price;
	}

	public void setCompare_at_price(String compare_at_price) {
		this.compare_at_price = compare_at_price;
	}

	public String getPosition ()
	{
		return position;
	}

	public void setPosition (String position)
	{
		this.position = position;
	}

	public String getWeight ()
	{
		return weight;
	}

	public void setWeight (String weight)
	{
		this.weight = weight;
	}

	public String getProduct_id ()
	{
		return product_id;
	}

	public void setProduct_id (String product_id)
	{
		this.product_id = product_id;
	}

	public String getTaxable ()
	{
		return taxable;
	}

	public void setTaxable (String taxable)
	{
		this.taxable = taxable;
	}

	public String getInventory_policy ()
	{
		return inventory_policy;
	}

	public void setInventory_policy (String inventory_policy)
	{
		this.inventory_policy = inventory_policy;
	}

	public String getBarcode ()
	{
		return barcode;
	}

	public void setBarcode (String barcode)
	{
		this.barcode = barcode;
	}

	public String getImage ()
	{
		return image;
	}

	public void setImage (String image)
	{
		this.image = image;
	}

	public String getWeight_unit ()
	{
		return weight_unit;
	}

	public void setWeight_unit (String weight_unit)
	{
		this.weight_unit = weight_unit;
	}

	public String getSku ()
	{
		return sku;
	}

	public void setSku (String sku)
	{
		this.sku = sku;
	}

	public String getFulfillment_service ()
	{
		return fulfillment_service;
	}
	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.created_at = now;
		this.status=true;
	}
	public void setFulfillment_service (String fulfillment_service)
	{
		this.fulfillment_service = fulfillment_service;
	}


	public String getOption1 ()
	{
		return option1;
	}

	public void setOption1 (String option1)
	{
		this.option1 = option1;
	}

	public String getTitle ()
	{
		return title;
	}

	public void setTitle (String title)
	{
		this.title = title;
	}

	public String getUpdated_at ()
	{
		return updated_at;
	}

	public void setUpdated_at (String updated_at)
	{
		this.updated_at = updated_at;
	}

	public String getPrice ()
	{
		return price;
	}

	public void setPrice (String price)
	{
		this.price = price;
	}

	public String getRequires_shipping ()
	{
		return requires_shipping;
	}

	public void setRequires_shipping (String requires_shipping)
	{
		this.requires_shipping = requires_shipping;
	}

	public String getOld_inventory_quantity ()
	{
		return old_inventory_quantity;
	}

	public void setOld_inventory_quantity (String old_inventory_quantity)
	{
		this.old_inventory_quantity = old_inventory_quantity;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getGrams ()
	{
		return grams;
	}

	public void setGrams (String grams)
	{
		this.grams = grams;
	}

	public String getInventory_management ()
	{
		return inventory_management;
	}

	public void setInventory_management (String inventory_management)
	{
		this.inventory_management = inventory_management;
	}

	public String getInventory_quantity ()
	{
		return inventory_quantity;
	}

	public void setInventory_quantity (String inventory_quantity)
	{
		this.inventory_quantity = inventory_quantity;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [position = "+position+", weight = "+weight+",Brand = "+brand+",weight = "+weight+", product_id = "+product_id+", taxable = "+taxable+", inventory_policy = "+inventory_policy+", barcode = "+barcode+", image = "+image+", weight_unit = "+weight_unit+", sku = "+sku+", fulfillment_service = "+fulfillment_service+", image_id = "+image_id+", option1 = "+option1+", id = "+id+", option2 = "+option2+", option3 = "+option3+", title = "+title+", updated_at = "+updated_at+", price = "+price+", requires_shipping = "+requires_shipping+", old_inventory_quantity = "+old_inventory_quantity+", created_at = "+created_at+", grams = "+grams+", inventory_management = "+inventory_management+", compare_at_price = "+compare_at_price+", inventory_quantity = "+inventory_quantity+"]";
	}
}

