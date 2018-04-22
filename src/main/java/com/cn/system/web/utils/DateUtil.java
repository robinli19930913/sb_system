package com.cn.system.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static long getDifferenceTime(Date date) {
		long difference = -1;
		if(date == null) {
			return difference;
		}
		difference = getDifferenceTime(date,new Date(),2);
		return difference;
	}
	
	private static long getDifferenceTime(Date startDate,Date endDate,int type) {
		long difference = -1;
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		if(type == 1) {//秒
			difference = (endTime - startTime)/1000;
		}
		if(type == 2) {//分
			difference = (endTime - startTime)/1000/60;
		}
		if(type == 3) {//时
			difference = (endTime - startTime)/1000/60/60;
		}
		return difference;
	}
	
	public static String getLastMonth(int value) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.MONTH, value);
        Date m = c.getTime();
        return format.format(m);
	}
	
	public static String getLastDayOfString(int value) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, value);
        Date m = c.getTime();
        return format.format(m);
	}
	
	public static Date getLastDayOfDate(int value) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, value);
        return c.getTime();
	}
	
	public static String getDateStr(Date date) {
		if(date == null) {
			date = new Date();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
	}
	
	public static String getDateStrOfFormat(Date date,String pattern) {
		if(date == null) {
			date = new Date();
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
	}
	
	public static Date getDateToStr(String strDate) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date strtodate = null;
		try {
			strtodate = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return strtodate;
	}
	
	public static String getTimeDifference(Date startDate,Date endDate) {
		String timeStr = "0分钟";
		Long time = (endDate.getTime() - startDate.getTime())/1000;//获取秒差
		Long m = time/60%60;//分
		Long h = time/60/60%24;//小时
		Long d = time/60/60/24;//天
		if(d > 0) {
			timeStr = d+"天"+h+"小时"+m+"分钟";
		}
		if(d <= 0 && h > 0) {
			timeStr = h+"小时"+m+"分钟";
		}
		if(d <= 0 && h <= 0 && m > 0) {
			timeStr = m+"分钟";
		}
		System.out.println(timeStr);
		return timeStr;
	}
	
	public static String getTimeDifference(String startDate,String endDate) throws ParseException {
		String timeStr = "0分钟";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date ds = formatter.parse(startDate);
		Date de = formatter.parse(endDate);
		Long time = (de.getTime() - ds.getTime())/1000;//获取秒差
		Long m = time/60%60;//分
		Long h = time/60/60%24;//小时
		Long d = time/60/60/24;//天
		if(d > 0) {
			timeStr = d+"天"+h+"小时"+m+"分钟";
		}
		if(d <= 0 && h > 0) {
			timeStr = h+"小时"+m+"分钟";
		}
		if(d <= 0 && h <= 0 && m > 0) {
			timeStr = m+"分钟";
		}
		System.out.println(timeStr);
		return timeStr;
	}
	
	public static void main(String[] args) {
//		String startDate = getDateStrOfFormat(getLastDayOfDate(-1),"yyyy-MM-dd");
//		String endDate = getDateStr(new Date());
//		System.out.println(startDate);
//		System.out.println(endDate);
		
		long m = -2;
		try {
			m = DateUtil.getDifferenceTime(getDateToStr("2018-01-26 17:31:22"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m);
	}
}
