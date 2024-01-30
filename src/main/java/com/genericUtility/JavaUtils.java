package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils
{
	/**
	 * This Method is used to get random number
	 * @author Aftab
	 * @param bound
	 * @return Int
	 */
public int getRabdomNumber(int bound) 
{
	Random random = new Random();
	int r = random.nextInt(bound);
	return r;
}
/**
 * This method is used to get System date
 * @author Aftab
 * @return String
 */

public String getSytemDate()
{
	Date dt = new Date();
	String date = dt.toString();
	return date;
}
/**
 * This method is used to get System date in format
 * @author Aftab
 * @return String
 */
public String getSystemDateInFormat()
{
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
	Date dt = new Date();
	String systemDateInFormat = dateformat.format(dt);
	return systemDateInFormat;
			
}
}
