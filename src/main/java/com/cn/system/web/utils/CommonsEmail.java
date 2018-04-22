package com.cn.system.web.utils;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class CommonsEmail {
	private static String host = "smtp.mxhichina.com";
	private static int port = 25;
	private static String userName = "mobomailsystem@mobopower.cn‍";
	private static String password = "MBa123456";
	// private static String userName = "17310442201@163.com";
	// private static String password = "zjmjmi888";
	// private String to = "365915659@qq.com";
	
	public static void sendEmail(String ht, List<String> to) {
		HtmlEmail mail = new HtmlEmail();
		try {
			// 设置邮箱服务器信息
			mail.setSmtpPort(port);
			mail.setHostName(host);
			// 设置密码验证器
			mail.setAuthentication(userName, password);
			// 设置邮件发送者
			mail.setFrom(userName);
			// 设置邮件接收者
			if (to.size() == 0) {
				return;
			} else {
				for (int i = 0; i < to.size(); i++) {
					mail.addTo(to.get(i));
				}
			}
			// 设置邮件编码
			mail.setCharset("UTF-8");
			// 设置邮件主题
			mail.setSubject("魔宝电源离线设备");
			// 设置邮件发送时间
			mail.setSentDate(new Date());
			// 设置邮件内容
			mail.setHtmlMsg(ht);

			// 发送邮件
			mail.send(); // TODO 带会儿 把这个地方的异常捕获以下输出 检查以下服务层
		} catch (EmailException email) {
			System.out.println("发送失败:----->>>" + email.toString());
		}
		System.out.println("======邮件发送成功");
	}
}
