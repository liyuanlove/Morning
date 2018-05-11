package org.pussinboots.morning.common.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Create by ZengShiLin on 2018-02-02
 * Redis缓存工具类
 * 缓存设置每30分钟刷新一次
 */
public class RedisCacheUtils {

    private static String ip = "119.29.209.127"; //redis ip
    private static Integer port = new Integer(6320); //redis 端口
    private static String keypref = "moling-index"; //平台缓存统一key前缀
    private static JedisPool jedisPool = new JedisPool(ip,port);
    public static boolean saveObject(Object obj,String key){
        return false;
    }
    public static Object getObject(String key){
        return null;
    }

    /**
     * 【平台缓存】
     * 为了更大程度的服用接口，这里使用json的方式直接保存数据
     */
    public static void saveJson(String json,String key,Integer time){
        Jedis  jedis = jedisPool.getResource();
        try{
            //序列化成json字符串保存
            jedis.set(keypref+key,json);
            jedis.expire(keypref+key,time);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    /**
     * 【平台缓存获取】
     * 为了更大程度的服用接口，这里使用json的方式直接保存数据
     */
    public static String getJson(String key){
        Jedis  jedis = jedisPool.getResource();
        String json = null;
        try{
             json = new String(jedis.get(keypref+key));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
        return json;
    }
}
