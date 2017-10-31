package com.online.market.user.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "UserRegister")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
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
	@Column(name = "isLogin")
	private boolean isLogin;
	@Column(name = "Name")
	private String name;
	@Column(name = "DirectorName")
	private String directorName;
	@Column(name = "pinCode")
	private String pin;
	@Column(name = "PermanentAddress")
	private String permanentAddress;
	@Column(name = "CommunicationAddressCode")
	private String communicationAddressCode;
	@Column(name = "MobileNo", length = 20, nullable = false)
	private String mobileNo;
	@Column(name = "RegTypeCode")
	private String regTypeCode;
	@Column(name = "RegTypeNo")
	private String regTypeNo;
	@Column(name = "BusinessNature")
	private String businessNature;
	@Column(name = "AnnualTurnover",nullable=true)
	private BigDecimal annualTurnover;
	@Column(name = "AnnualIncome",nullable=true)
	private BigDecimal annualIncome;
	@Column(name = "NoOfBusinessYear")
	private Integer noOfBusinessYear;
	@Column(name = "PAN")
	private String pan;
	@Column(name = "DirectorName1")
	private String directorName1;
	@Column(name = "DirectorAddress1")
	private String directorAddress1;
	@Column(name = "DirectorName2")
	private String directorName2;
	@Column(name = "DirectorAddress2")
	private String directorAddress2;
	@Column(name = "ContactName")
	private String contactName;
	@Column(name = "ContactNo")
	private String contactNo;
	@Column(name = "MerchantBankDetailsCode")
	private String merchantBankDetailsCode;
	@Column(name = "CodeMasterIdentityTypeCode")
	private String identityTypeCode;
	@Column(name = "CodeMasterAddressProofCode")
	private String addressProofCode;
	@Column(name = "ContactEmail", length = 20, nullable = false)
	private String contactEmail;
	@Column(name = "FirmDetailsA")
	private String firmDetailsA;
	@Column(name = "FirmDetailsB")
	private String firmDetailsB;
	@Column(name = "FirmDetailsC")
	private String firmDetailsC;
	@Column(name = "FirmDetailsD")
	private String firmDetailsD;
	@Column(name = "IsCDR")
	private boolean isCDR;
	@Column(name = "IsMDR")
	private boolean isMDR;
	@Column(name = "errorCode")
	private Integer errorCode;
	@Column(name = "errorDesc")
	private String errorDesc;
	@Column(name = "UserType")
	private String userType;
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
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
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
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
	public boolean isCDR() {
		return isCDR;
	}
	public void setCDR(boolean isCDR) {
		this.isCDR = isCDR;
	}
	public boolean isMDR() {
		return isMDR;
	}
	public void setMDR(boolean isMDR) {
		this.isMDR = isMDR;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public boolean isActive() {
		return isActive;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDirectorName() {
		return directorName;
	}

	
	public String getCommunicationAddressCode() {
		return communicationAddressCode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getRegTypeCode() {
		return regTypeCode;
	}
	public String getRegTypeNo() {
		return regTypeNo;
	}
	public String getBusinessNature() {
		return businessNature;
	}
	public BigDecimal getAnnualTurnover() {
		return annualTurnover;
	}
	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}
	public Integer getNoOfBusinessYear() {
		return noOfBusinessYear;
	}
	public String getPan() {
		return pan;
	}
	public String getDirectorName1() {
		return directorName1;
	}
	public String getDirectorAddress1() {
		return directorAddress1;
	}
	public String getDirectorName2() {
		return directorName2;
	}
	public String getDirectorAddress2() {
		return directorAddress2;
	}
	public String getContactName() {
		return contactName;
	}
	public String getContactNo() {
		return contactNo;
	}

	public String getIdentityTypeCode() {
		return identityTypeCode;
	}
	public String getAddressProofCode() {
		return addressProofCode;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public String getFirmDetailsA() {
		return firmDetailsA;
	}
	public String getFirmDetailsB() {
		return firmDetailsB;
	}
	public String getFirmDetailsC() {
		return firmDetailsC;
	}
	public String getMerchantBankDetailsCode() {
		return merchantBankDetailsCode;
	}
	public String getFirmDetailsD() {
		return firmDetailsD;
	}
	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.createdDate = now;
		this.isActive = true;
	}
	public static Builder getBuilder() {
		return new Builder();
	}

	public void setNoOfBusinessYear(Integer noOfBusinessYear) {
		this.noOfBusinessYear = noOfBusinessYear;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public void setCommunicationAddressCode(String communicationAddressCode) {
		this.communicationAddressCode = communicationAddressCode;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setRegTypeCode(String regTypeCode) {
		this.regTypeCode = regTypeCode;
	}
	public void setRegTypeNo(String regTypeNo) {
		this.regTypeNo = regTypeNo;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public void setAnnualTurnover(BigDecimal annualTurnover) {
		this.annualTurnover = annualTurnover;
	}
	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}
	public void setDirectorName1(String directorName1) {
		this.directorName1 = directorName1;
	}
	public void setDirectorAddress1(String directorAddress1) {
		this.directorAddress1 = directorAddress1;
	}
	public void setDirectorName2(String directorName2) {
		this.directorName2 = directorName2;
	}
	public void setDirectorAddress2(String directorAddress2) {
		this.directorAddress2 = directorAddress2;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setMerchantBankDetailsCode(String merchantBankDetailsCode) {
		this.merchantBankDetailsCode = merchantBankDetailsCode;
	}
	public void setIdentityTypeCode(String identityTypeCode) {
		this.identityTypeCode = identityTypeCode;
	}
	public void setAddressProofCode(String addressProofCode) {
		this.addressProofCode = addressProofCode;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public void setFirmDetailsA(String firmDetailsA) {
		this.firmDetailsA = firmDetailsA;
	}
	public void setFirmDetailsB(String firmDetailsB) {
		this.firmDetailsB = firmDetailsB;
	}
	public void setFirmDetailsC(String firmDetailsC) {
		this.firmDetailsC = firmDetailsC;
	}
	public void setFirmDetailsD(String firmDetailsD) {
		this.firmDetailsD = firmDetailsD;
	}




	public static class Builder {

		private UserRegistration userAccount;

		public Builder() {
			userAccount = new UserRegistration();

		}

		public Builder name(String name)
		{
			userAccount.name = name;
			return this;
		}
		public Builder directorName(String directorName)
		{
			userAccount.directorName = directorName;
			return this;
		}


		public Builder communicationAddressCode(String communicationAddressCode)
		{
			userAccount.communicationAddressCode = communicationAddressCode;
			return this;
		}

		public Builder businessNature(String businessNature)
		{
			userAccount.businessNature = businessNature;
			return this;
		}
		public Builder contactName(String contactName)
		{
			userAccount.contactName = contactName;
			return this;
		}
		public Builder contactNo(String contactNo)
		{
			userAccount.contactNo = contactNo;
			return this;
		}
		public Builder contactEmail(String contactEmail)
		{
			userAccount.contactEmail = contactEmail;
			return this;
		}


		public Builder mobileNo(String mobileNo)
		{
			userAccount.mobileNo = mobileNo;
			return this;
		}	
				public Builder regTypeCode(String regTypeCode)
		{
			userAccount.regTypeCode = regTypeCode;
			return this;
		}	
		public Builder regTypeNo(String regTypeNo)
		{
			userAccount.regTypeNo = regTypeNo;
			return this;
		}	
		public Builder annualTurnover(BigDecimal annualTurnover)
		{
			userAccount.annualTurnover = annualTurnover;
			return this;
		}	

		public Builder annualIncome(BigDecimal annualIncome)
		{
			userAccount.annualIncome = annualIncome;
			return this;
		}	

		public Builder noOfBusinessYear(Integer noOfBusinessYear)
		{
			userAccount.noOfBusinessYear = noOfBusinessYear;
			return this;
		}	

		public Builder pan(String pan)
		{
			userAccount.pan = pan;
			return this;
		}	

		public Builder directorName1(String directorName1)
		{
			userAccount.directorName1 = directorName1;
			return this;
		}	

		public Builder directorName2(String directorName2)
		{
			userAccount.directorName2 = directorName2;
			return this;
		}	

		public Builder directorAddress1(String directorAddress1)
		{
			userAccount.directorAddress1 = directorAddress1;
			return this;
		}	

		public Builder directorAddress2(String directorAddress2)
		{
			userAccount.directorAddress2 = directorAddress2;
			return this;
		}	
		public Builder identityTypeCode(String identityTypeCode)
		{
			userAccount.identityTypeCode = identityTypeCode;
			return this;
		}	

		public Builder addressProofCode(String addressProofCode)
		{
			userAccount.addressProofCode = addressProofCode;
			return this;
		}	

		public Builder firmDetailsA(String firmDetailsA)
		{
			userAccount.firmDetailsA = firmDetailsA;
			return this;
		}	

		public Builder firmDetailsB(String firmDetailsB)
		{
			userAccount.firmDetailsB = firmDetailsB;
			return this;
		}	

		public Builder firmDetailsC(String firmDetailsC)
		{
			userAccount.firmDetailsC = firmDetailsC;
			return this;
		}	
		public Builder firmDetailsD(String firmDetailsD)
		{
			userAccount.firmDetailsD = firmDetailsD;
			return this;
		}	

		public Builder merchantBankDetailsCode(String merchantBankDetailsCode)
		{
			userAccount.merchantBankDetailsCode = merchantBankDetailsCode;
			return this;
		}

		public UserRegistration build() {
			return userAccount;
		}
	}

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}

