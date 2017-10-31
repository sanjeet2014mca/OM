package com.online.market.login.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "view_All_User_Details")
public class LoginEntity {
	@Id
	//@Column(name="VehicleRegistrationNo")
	@Column(name = "Id")
	private String id;
	@Column(name = "Password")
	private String Password;
	@Column(name = "DefaultPassword")
	private String DefaultPassword;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Date createdDate;
	@Column(name = "IsActive")
	private boolean isActive;
	@Column(name = "Name")
	private String name;
	@Column(name = "PinCode")
	private String pin;
	@Column(name = "PermanentAddress")
	private String permanentAddress;
	
	@Column(name = "MobileNo", length = 20, nullable = false)
	private String mobileNo;
	
	@Column(name = "PAN")
	private String pan;
	
	@Column(name = "ContactName")
	private String contactName;
	
	@Column(name = "ContactEmail", length = 20, nullable = false)
	private String contactEmail;
	
	@Column(name = "errorCode")
	private Integer errorCode;
	@Column(name = "errorDesc")
	private String errorDesc;
	@Column(name = "UserType")
	private String userType;
	@Column(name = "status")
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDefaultPassword() {
		return DefaultPassword;
	}
	public void setDefaultPassword(String defaultPassword) {
		DefaultPassword = defaultPassword;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.createdDate = now;
		this.isActive = true;
	}
}
