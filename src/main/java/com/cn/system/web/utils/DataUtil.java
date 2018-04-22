package com.cn.system.web.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DataUtil {
	/**
	  * 密码类型枚举
	  * @author ASUS
	  */
	 public static enum TYPE {
	  /**
	   * 字符型
	   */
	  LETTER,
	  /**
	   * 大写字符型
	   */
	  CAPITAL,
	  /**
	   * 数字型
	   */
	  NUMBER,
	  /**
	   * 大+小字符 型
	   */
	  LETTER_CAPITAL,
	  /**
	   * 小字符+数字 型
	   */
	  LETTER_NUMBER,
	  /**
	   * 大+小字符+数字 型
	   */
	  LETTER_CAPITAL_NUMBER,
	 }

	 private static String[] lowercase = {
	   "a","b","c","d","e","f","g","h","i","j","k",
	   "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	 private static String[] capital = {
	   "A","B","C","D","E","F","G","H","I","J","K",
	   "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 

	 private static String[] number = {
	   "1","2","3","4","5","6","7","8","9","0"};
	 /**
	  * 静态随机数
	  */
	 private static Random random = new Random();

	 public static void main(String[] args) {
		 //System.out.println(DataUtil.getRandom(8, DataUtil.TYPE.LETTER_CAPITAL_NUMBER));
		 System.out.println(getMd5Password("123"));
		 //String data = DateUtil.getDateStrOfFormat(new Date(), "yyyyMMddHHmmss");
		 //System.out.println(data+DataUtil.getRandom(6, DataUtil.TYPE.LETTER_CAPITAL_NUMBER));
	 }
	 
	 /**
	  * 获取yyyyMMddHHmmss + num位随机字符
	  * @param num 随机字符数
	  * @return
	  */
	 public static String getDateRandomStr(int num) {
		 return DateUtil.getDateStrOfFormat(new Date(), "yyyyMMddHHmmss") + getRandom(num, TYPE.LETTER_CAPITAL_NUMBER);
	 }

	 /**
	  * 获取随机组合码
	  * @param num 位数
	  * @param type 类型
	  * @type
	  * <br>字符型 LETTER,
	  * <br>大写字符型 CAPITAL,
	  * <br>数字型 NUMBER,
	  * <br>大+小字符型 LETTER_CAPITAL,
	  * <br>小字符+数字 型 LETTER_NUMBER,
	  * <br>大+小字符+数字 型 LETTER_CAPITAL_NUMBER
	  */
	 public static String getRandom(int num,TYPE type){
	  ArrayList<String> temp = new ArrayList<String>();
	  StringBuffer code = new StringBuffer();
	  if(type == TYPE.LETTER){
	   temp.addAll(Arrays.asList(lowercase));
	  }else if(type == TYPE.CAPITAL){
	   temp.addAll(Arrays.asList(capital));
	  }else if(type == TYPE.NUMBER){
	   temp.addAll(Arrays.asList(number));
	  }else if(type == TYPE.LETTER_CAPITAL){
	   temp.addAll(Arrays.asList(lowercase));
	   temp.addAll(Arrays.asList(capital));
	  }else if(type == TYPE.LETTER_NUMBER){
	   temp.addAll(Arrays.asList(lowercase));
	   temp.addAll(Arrays.asList(number));
	  }else if(type == TYPE.LETTER_CAPITAL_NUMBER){
	   temp.addAll(Arrays.asList(lowercase));
	   temp.addAll(Arrays.asList(capital));
	   temp.addAll(Arrays.asList(number));
	  }
	  for (int i = 0; i < num; i++) {
		  code.append(temp.get(random.nextInt(temp.size())));
	  }
	  return code.toString();
	 }
	 
	 public static String getMd5Password(String password) {
		 return MD5Util.MD5Encode(password, "UTF-8");
	 }
	 

    public static String getIpAddr(HttpServletRequest request) {  
    	String ipAddress = request.getHeader("x-forwarded-for");  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getHeader("Proxy-Client-IP");  
        }  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getRemoteAddr();  
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                //根据网卡取本机配置的IP  
                InetAddress inet=null;  
                try {  
                    inet = InetAddress.getLocalHost();  
                } catch (UnknownHostException e) {  
                    e.printStackTrace();  
                }  
                ipAddress= inet.getHostAddress();  
            }  
        }  
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
            if(ipAddress.indexOf(",")>0){  
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
            }  
        }  
        return ipAddress;
   }  
}
