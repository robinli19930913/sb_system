//package com.cn.system.web.utils;
//
//import org.apache.commons.lang3.math.NumberUtils;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Properties;
//import java.util.Set;
//
///**
// * 功能描述：
// *
// * @author yejianzhou
// * @since 2018-02-02
// */
//public class RedisUtil {
//    public static JedisCluster getJedisCluster(String env) throws IOException {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream(new File("D:\\workspace\\config-proertites\\" + env + "\\owhat_cache_redis.properties")));
//        Set<HostAndPort> hostAndPorts = new HashSet<>();
//        for (int i = 1; i <= 6; i++) {
//            String ip = properties.getProperty("redis.ip." + i);
//            int port = NumberUtils.toInt(properties.getProperty("redis.port." + i));
//            HostAndPort hostAndPort = new HostAndPort(ip, port);
//            hostAndPorts.add(hostAndPort);
//        }
//        return new JedisCluster(hostAndPorts);
//    }
//
//    public static JedisCluster getDev() {
//        try {
//            return getJedisCluster("dev");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static JedisCluster getTest1() {
//        try {
//            return getJedisCluster("test");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static JedisCluster getTest2() {
//        try {
//            return getJedisCluster("test2");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static JedisCluster getProd() {
//        try {
//            return getJedisCluster("prod-dev");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
