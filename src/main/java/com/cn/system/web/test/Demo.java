package com.cn.system.web.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robin on 2018/5/21.
 */
public class Demo {
    public static void main(String[] args) {
        Integer num = 123;
        String onlyStringByNumber = getOnlyStringByNumber(num);
        Integer numberByOnlyString = getNumberByOnlyString(onlyStringByNumber);
        System.out.println("加密数值："+num);
        System.out.println("加密字符串："+onlyStringByNumber);
        System.out.println("解密数值："+numberByOnlyString);
    }

    /**
     * 字符集合
     */
    private static final List<Character> list = Arrays.asList('A', 'R', 'C', 'S', 'E', 'F', 'T', 'H', 'I', 'J','Q', 'I', 'B', 'K', 'L', 'D', 'N', 'O', 'P', 'M');

    /**
     * 根据传入的数字生成一个唯一字符串
     * 规则：1.从左往右第一位直接对应list索引 从第二位开始每一位都是前一位与当前位和对应list索引
     *  // 2.从左向右 每一位找到对应字母后，在后面追加当前位数/2 为索引的list里面的字母（此条规则暂时不用）
     * @param number
     * @return
     */
    private static String getOnlyStringByNumber(Integer number){
        if(number == null){
            return "";
        }
        char[] chars = number.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < chars.length;i++){
            Character character;
            if(i == 0){
                character = list.get(Integer.parseInt(String.valueOf(chars[i])));
            }else{
                character = list.get(Integer.parseInt(String.valueOf(chars[i-1]))+Integer.parseInt(String.valueOf(chars[i])));
            }
            sb.append(character);
            //sb.append(list.get(Integer.parseInt(String.valueOf(chars[i]))/2));//多加字母
        }
        return sb.toString();
    }

    /**
     * 根据唯一字符串解析出数值
     * @param charStr
     * @return
     */
    private static Integer getNumberByOnlyString(String charStr){
        if(StringUtils.isBlank(charStr)){
            return null;
        }
        char[] chars = charStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        Integer num = 0;
        for(int i = 0;i < chars.length;i++){
            //if(i%2 == 0){//剔除多加字母
                if(i==0){
                    num = list.lastIndexOf(chars[i]);
                    sb.append(num);
                }else{
                    num = list.lastIndexOf(chars[i]) - num;
                    sb.append(num);
                }
            //}
        }
        return Integer.parseInt(sb.toString());
    }
}
