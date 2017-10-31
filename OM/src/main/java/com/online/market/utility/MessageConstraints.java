package com.online.market.utility;
public interface MessageConstraints{

	public static enum Error {
		USERREGISTER(1000, "User Registered Successfully"),
		DUPLICATEUSER(1001, "User Already Exists."),
		USERNOTEXISTS(1002, "User Doesn't Exists."),
		INTERNALSERVERERROR(1003, "Internal Server Error."),
		USERUPDATEDSUCCESSFULLY(1005, "User  Updated Successfully."),
		USERNOTUPDATED(1006, "User Not Updated."),
		USERLOGINSUCCESSFULLY(1007, "Successfully Login."),
		INVALIDPASSWORD(1008, "Invalid Password."),
		USERDETAILS(1009, "User Details."),
		PASSWORDUSERUPDATEDSUCCESSFULLY(1010, "Password Successfully."),

		MERCHANTREGISTER(2000, "Merchant Registered Successfully"),
		DUPLICATEMERCHANT(2001, "Merchant Already Exists."),
		MERCHANTNOTEXISTS(2002, "Merchant Doesn't Exists."),
		MERCHANTUPDATEDSUCCESSFULLY(2005, "Merchant  Updated Successfully."),
		MERCHANTNOTUPDATED(2006, "Merchant Not Updated."),
		MERCHANTLOGINSUCCESSFULLY(2007, "Successfully Login."),
		MERCHANTDETAILS(2009, "Merchant Details."),
		PASSWORDMERCHANTUPDATEDSUCCESSFULLY(2010, "Password Updated Successfully."),
		
		PRODUCTINSERTEDSUCCESSFULLY(3000, "Product Inserted Successfully."),
		PRODUCTINSERTFAILED(3001, "Product Insetion Failed.");
		
		
		
		private final int code;
		private final String description;

		private Error(int code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public int getCode() {
			return code;
		}

		@Override
		public String toString() {
			return code + ": " + description;
		}
	}}