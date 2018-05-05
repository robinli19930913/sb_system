package com.cn.system.web.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

/**
 * Created by robin on 2018/5/5.
 */
public class TestSend
{
    /**
     * 注意：个人邮箱作为发送邮箱，必须进行下面设置
     * 进入邮箱【首页】——>【设置】——>【POP3/SMTP/IMAP】——>【设置POP3/SMTP/IMAP】，
     * 把【POP3/SMTP服务】和【IMAP/SMTP服务】全部勾上，此时会弹出一个框要你设置（授权码），
     * 那就去设置，总之，记住这个（授权码），后面用的上。
     * @param args
     * @throws MessagingException
     * @throws IOException
     */
    public static void main(String[] args) throws MessagingException, IOException
    {

        Map<String,String> map= new HashMap<>();
        SendMail mail = new SendMail("2456309785@qq.com","rjoocioxrwwldjbb");
        map.put("mail.smtp.host", "smtp.qq.com");
        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        mail.setPros(map);
        mail.initMessage();
        /*
         * 添加收件人有三种方法：
         * 1,单人添加(单人发送)调用setRecipient(str);发送String类型
         * 2,多人添加(群发)调用setRecipients(list);发送list集合类型
         * 3,多人添加(群发)调用setRecipients(sb);发送StringBuffer类型
         */
        List<String> list = new ArrayList<>();
        list.add("2900747742@qq.com");
        list.add("viplixuegen@163.com");
        mail.setRecipients(list);
        mail.setSubject("测试邮箱,谢谢合作。");
        mail.setDate(new Date());
        mail.setFrom("MY");//来自谁可以是发送邮箱账号也可以设置其他例如：百度推广等等。
//      mail.setMultipart("D:你你你.txt");//附件
        String html = "<html lang='zh-CN'><head ><meta charset='utf-8'>" +
                "</head><body>内容：这是我发的第一封Java邮件" +
                "<a href='http://www.baidu.com'>【百度一下】</a></body></html>";
        mail.setContent(html, "text/html; charset=UTF-8");
        System.out.println(mail.sendMessage());
    }

}
