package com.cn.system.web.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpClientUtils {
	
	public static void main(String[] args) {
		try {
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("message", "bac");
			paramMap.put("sessionid", "2022");
			HttpClientUtils.httpPostJSONObject(paramMap, "http://192.168.1.196:8080/mobopower/tcp/heartbeat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JSONObject httpGetJSONObject(Map<String, String> paramMap,String url){
		//使用默认配置的httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
		url += "?";
		for(Entry<String, String> entry : paramMap.entrySet()) {
			url += (entry.getKey()+"="+entry.getValue()) + "&";
		}
		System.out.println(url);
		HttpGet httpGet = new HttpGet(url);
	    
		CloseableHttpResponse httpResponse = null;
		JSONObject jsonObject = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			//打印请求的状态码  请求成功为200
	        System.out.println(httpResponse.getStatusLine().getStatusCode());
	        HttpEntity entity = httpResponse.getEntity();
	        if(entity != null) {
	        	jsonObject = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
	        }
	        //释放资源
	        EntityUtils.consume(entity);
		} catch (Exception e) {
			System.out.println("请求异常,请求链接："+url);
			return null;
		}finally {
			if(httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					System.out.println("请求异常,请求链接："+url);
					return null;
				}
			}
		}
		
        
	    return jsonObject;
	}
	
	/**
	 * POST请求
	 * @param paramMap 请求参数
	 * @param url 路径
	 * @return JSONObject
	 * @throws IOException
	 */
	public static JSONObject httpPostJSONObject(Map<String, String> paramMap,String url) {
        String encoding = "utf-8";
        //创建默认的httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求对象
        HttpPost httpPost = new HttpPost(url);
        //装填请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : paramMap.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        
        CloseableHttpResponse response = null;
        JSONObject jsonObject = null;
        try {
        	//设置参数到请求对象中
			httpPost.setEntity(new UrlEncodedFormEntity(list,encoding));
			System.out.println("请求地址："+url);
	        System.out.println("请求参数："+list.toString());

	        //设置header信息
	        //指定报文头【Content-type】、【User-Agent】
	        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
	        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

	        //执行请求操作，并拿到结果（同步阻塞）
	        response = httpClient.execute(httpPost);
	        //获取所有的请求头信息
	        Header[] allHeaders = response.getAllHeaders();
	        for (Header allHeader : allHeaders) {
	            System.out.println(allHeader.toString());
	        }
	        //获取结果实体
	        HttpEntity entity = response.getEntity();
	        
	        if(entity != null) {
	        	jsonObject = JSONObject.fromObject(EntityUtils.toString(entity,encoding));
	        }
	        //关流
	        EntityUtils.consume(entity);
		} catch (Exception e) {
			System.out.println("请求异常,请求链接："+url);
			return null;
		}finally {
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
					System.out.println("请求异常,请求链接："+url);
					return null;
				}
			}
		}
        return jsonObject;
    }
	
	/**
	 * POST请求
	 * @param paramMap 请求参数
	 * @param url 路径
	 * @return String
	 * @throws IOException
	 */
	public static String httpPostString(Map<String, String> paramMap,String url) throws IOException {
		String encoding = "utf-8";
        //创建默认的httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求对象
        HttpPost httpPost = new HttpPost(url);
        //装填请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : paramMap.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
        	//设置参数到请求对象中
			httpPost.setEntity(new UrlEncodedFormEntity(list,encoding));
			System.out.println("请求地址："+url);
	        System.out.println("请求参数："+list.toString());

	        //设置header信息
	        //指定报文头【Content-type】、【User-Agent】
	        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
	        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

	        //执行请求操作，并拿到结果（同步阻塞）
	        response = httpClient.execute(httpPost);
	        //获取所有的请求头信息
	        Header[] allHeaders = response.getAllHeaders();
	        for (Header allHeader : allHeaders) {
	            System.out.println(allHeader.toString());
	        }
	        //获取结果实体
	        HttpEntity entity = response.getEntity();
	        
	        if(entity != null) {
	        	result = EntityUtils.toString(entity,encoding);
	        }
	        //关流
	        EntityUtils.consume(entity);
		} catch (Exception e) {
			System.out.println("请求异常,请求链接："+url);
			return null;
		}finally {
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
					System.out.println("请求异常,请求链接："+url);
					return null;
				}
			}
		}
        return result;
    }
	 
}
