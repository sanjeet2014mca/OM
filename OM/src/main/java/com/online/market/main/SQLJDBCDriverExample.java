package com.online.market.main;

import com.online.market.utility.MessageConstraints;
import com.online.market.utility.RandomString;

public class SQLJDBCDriverExample
	{
	  public static void main(String[] args)
	  {/*
	    Connection connection = null;
	    try
	    {
	    	  // the sql server driver string
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    
		      // the sql server url
		      
		      String url = "jdbc:sqlserver://localhost:1433;" +
	            "databaseName=ApnaMoney";
		      
	      // get the sql server database connection
	      connection = DriverManager.getConnection(url,"sa", "admin123");
	      
	      // now do whatever you want to do with the connection
	      // ...
	      
	      System.out.println("connected:"+connection);
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }*/
		 // RandomString gen = new RandomString(8, ThreadLocalRandom.current()); 
		  RandomString gen = new RandomString();
		  String gen1=gen.nextString();
		  System.out.println(gen1);//u8cPb9WYvTKAQYVk3v86o
		 System.out.println(MessageConstraints.Error.DUPLICATEUSER.getCode()); 
	  }
	}