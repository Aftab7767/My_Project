package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	Connection con;
	Statement state;
	/**
	 * This method is used to connect the Driver for Databse
	 * @author Aftab
	 * @throws SQLException
	 */
public void connectToDB() throws SQLException
{
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection(IpathConstant.DBPATH,IpathConstant.DBUSERNAME,IpathConstant.DPASSWORD);
}

/**
 * This method is used to execute Select query
 * @author Aftab
 * @param query
 * @return ResultSet
 * @throws SQLException
 */
public String executeSelectQuery(String query,int colIndex,String ExpData) throws SQLException
{
	 state = con.createStatement();
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actual = result.getString(colIndex);
		if(actual.equalsIgnoreCase(ExpData))
		{
			flag = true;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("Data Verified");
		return ExpData;
	}
	else
	{
		System.out.println("Data is not verified");
	}
	return "";
	
}
/**
 * This method is used to execute Update query
 * @param query
 * @return int
 * @throws SQLException
 */
public int executeUodateQuery(String query) throws SQLException
{
	state=con.createStatement();
	int result = state.executeUpdate(query);
	return result;
}
/**
 * This method is used to close the database connection
 * @author Aftab
 * @throws SQLException
 */
public void closeDatabaseConnection() throws SQLException
{
	con.close();
}
}
