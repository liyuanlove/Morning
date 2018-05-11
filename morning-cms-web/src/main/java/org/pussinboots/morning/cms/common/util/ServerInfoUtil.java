package org.pussinboots.morning.cms.common.util;

import java.net.InetAddress;
import java.util.Map;
import java.util.Properties;

/**
 * Create by ZengShiLin on 2018-03-12
 * 获取服务器信息
 */
public class ServerInfoUtil {

    public static String getServerInfo(){
        String info = null;
        try {
            Runtime r = Runtime.getRuntime();
            Properties props = System.getProperties();
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress();
            Map<String, String> map = System.getenv();
            String computerName = map.get("COMPUTERNAME");// 获取计算机名
            info = "<p>计算机名："+computerName+"</p>"
                    +"<p>服务器ip："+ip+"</p>"
                    +"<p>JVM可用总内存："+ r.totalMemory()+"</p>"
                    +"<p>JVM可用总剩余内存："+  r.freeMemory()+"</p>"
                    +"<p>JVM可用处理器数量："+ r.availableProcessors()+"</p>"
                    +"<p>Java的运行环境版本："+ props.getProperty("java.version")+"</p>"
                    +"<p>操作系统的名称："+ props.getProperty("os.name")+"</p>"
                    +"<p>操作系统的版本："+ props.getProperty("os.version")+"</p>";
        }catch (Exception e){
            e.printStackTrace();
        }
        return info;
    }





}
