package com.online.market.utility;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DateUtils {
	
	public static final int DAY = Calendar.DATE;
	public static final int HOUR = Calendar.HOUR;
	public static final int MINUTE = Calendar.MINUTE;
	public static final int SECOND = Calendar.SECOND;
	public static final int YEAR = Calendar.YEAR;
	
	private String startDate;
	private String endDate;
	
	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		dateFormat.setLenient(false);
		String strDate =null;
		try{
			strDate = dateFormat.format(date);	
		}catch(Exception e)
		{
			return null;
		}
		return strDate;
	}
	public static String convertDateToString(String format,Date date) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		String strDate =null;
		try{
			strDate = dateFormat.format(date);	
		}catch(Exception e)
		{
			return null;
		}
		return strDate;
	}
	public static Date ConvertStringToDate(String dob) throws ParseException {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		Date date=df.parse(dob);
		return date;
	}
	
	public static Date ConvertStringToDate(String format, String dob) throws ParseException {
		DateFormat df=new SimpleDateFormat(format);
		df.setLenient(false);
		Date date=df.parse(dob);
		
		return date;
	}
	
	public static String formatStringDate(String strDate) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setLenient(false);
		Date date = df.parse(strDate);
		String formatedDate = df.format(date);
		
		return formatedDate;
	}
	
	
	public  static String formatFloatValue(float val) 	
	{
		String formattedFloat = null;
		try{
		NumberFormat formatter = new DecimalFormat("#0.00");
		formattedFloat = formatter.format(val);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return formattedFloat;
	}
	
	public static String formatStringFloatValue(String val) 	
	{
		String formattedFloat = null;
		try{
		NumberFormat formatter = new DecimalFormat("#0.00");
		formattedFloat = formatter.format(Float.valueOf(val));
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return formattedFloat;
	}
	public static boolean matchPattern(String regExp, String textTobeMatched)
	{
		boolean isMatch = false;
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(textTobeMatched);
		isMatch = matcher.find()?true:false;
		return isMatch;
		
	}
	
	
	public static boolean isAbove18years(Date dob)
	{
		Calendar current = Calendar.getInstance();
		Calendar dobYear = Calendar.getInstance();
		current.add(Calendar.YEAR, -18);
		dobYear.setTime(dob);
		if(dobYear.get(Calendar.YEAR)>current.get(Calendar.YEAR))
			return false;
			else
		
		
		return true;
		
	}
	
	public static boolean isValidDate(String myDate)
	{
		try{
			if(myDate.length() != 8)
			{
				System.err.println("Un parsable date format. please provide ddMMyyyy");
				return false;
			}
			int year = Integer.parseInt(myDate.substring(4,8));        
			int month = Integer.parseInt(myDate.substring(2,4));         
			int day = Integer.parseInt(myDate.substring(0,2)); 

			/*System.out.println("Year->"+year);
			System.out.println("Month->"+month);
			System.out.println("Day->"+day);*/

			if(year < 1900){
				System.err.println("Please enter proper year");
				return false;
			}
			if(month < 1 || month > 12){
				System.err.println("Please enter months between 1 to 12.");
				return false;
			}else
			{
				month--;
			}
/**
 * jan
 * mar
 * may
 * july
 * aug
 * oct 
 * dec
 */
			if(month == Calendar.JANUARY || month == Calendar.MARCH || month == Calendar.MAY || month == Calendar.JULY || month == Calendar.AUGUST || month == Calendar.OCTOBER || month == Calendar.DECEMBER){
				if(day > 31 || day < 1){
					System.err.print("Please enter day between 1 to 31.");
					return false;
				}
			}
			else if(month == Calendar.APRIL || month == Calendar.JUNE || month == Calendar.SEPTEMBER || month == Calendar.NOVEMBER){
				if(day > 30 || day < 1){
					System.err.print("Please enter day between 1 to 30.");
					return false;
				}
			}
			else{
				if(new GregorianCalendar().isLeapYear(year)){
					if(day < 1 || day > 29){
						System.err.print("Please enter day between 1 to 29.");
						return false;
					}
				}
				else if(day < 1 || day > 28){
					System.err.print("Please enter day between 1 to 28.");
					return false;
				}
			}
		}catch(NumberFormatException e)
		{
			System.err.print(e.getMessage() + " is not a legal entry!");
			return false;

		}catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public static Date getValidTime(Date requestDate,int field, int amount)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(requestDate);
		cal.add(field, amount);
		Date validTime = cal.getTime();
		return validTime;

	}
	
	public String getMonthStartDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		this.startDate = convertDateToString("yyyy-MM-dd",calendar.getTime());
		return startDate;
	}

	
	public String getMonthEndDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		this.endDate = convertDateToString("yyyy-MM-dd",calendar.getTime());
		return endDate;
	}


}
