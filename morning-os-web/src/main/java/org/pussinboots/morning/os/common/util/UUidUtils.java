package org.pussinboots.morning.os.common.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * Create by ZengShiLin on 2018-02-05
 * 用来产生UUID的工具类
 */
public class UUidUtils {

    private static Random random = new Random();
    public static String getUUid(){
        //加盐加密
        String salt = "monring";
        //生成随机数
        int code = random.nextInt(10000);
        //通过随机数和时间戳组合成唯一的id
        String source = salt+Integer.toString(code)+System.currentTimeMillis();
        //MD5加密后的Token
        String UUID = DigestUtils.md5DigestAsHex(source.getBytes());
        return UUID;
    }
}
