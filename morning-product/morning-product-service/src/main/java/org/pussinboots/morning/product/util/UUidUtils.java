package org.pussinboots.morning.product.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Random;

/**
 * Create by ZengShiLin on 2018-02-05
 * 用来产生UUID的工具类
 */
public class UUidUtils {

    private static Random random = new Random();
    /*
     *获得随机ID
     */
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

    /**
     * 获得有时间规律的id
     * @return
     */
    public static String getTimeId(Integer categotyID){
        StringBuffer str = new StringBuffer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        int date = Calendar.getInstance().get(Calendar.DATE);
        //商品前缀
        str.append("mo");
        str.append(year);
        if(month<10){
            str.append(0);
            str.append(month);
        }else{
            str.append(month);
        }
        if(date<10){
            str.append(0);
            str.append(date);
        }else {
            str.append(date);
        }
        str.append(categotyID);
        str.append(random.nextInt(1000));
        return str.toString();
    }




    public static Long getIntegerID(){
        Long id = System.currentTimeMillis();
        return id;
    }


}
