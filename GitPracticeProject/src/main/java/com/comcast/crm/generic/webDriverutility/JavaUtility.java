package com.comcast.crm.generic.webDriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random random=new Random();
		int randomInt=random.nextInt(5000);
		return randomInt;
		
	}
	public String getSystemDateYYYYDDMM()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
		
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance(); // start from current system date
	    cal.add(Calendar.DAY_OF_MONTH, days);  // add days
	    return sdf.format(cal.getTime());      // format result
		
	}
}
