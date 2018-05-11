package org.pussinboots.morning.product.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * Create by ZengShiLin on 2018-02-09
 * 这个是用来上传到FastDfs的工具类
 */
public class FastdfsUtil {

    static{
        try {
            //String FILEURL = FastdfsUtil.class.getClassLoader().getResource("config/client.conf").toString();
            //System.out.println(FILEURL);
            //先写死
            ClientGlobal.initByTrackers("119.29.209.127:22122");
            //ClientGlobal.init("tracker_server=119.29.209.127:22122");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TrackerClient trackerClient = new TrackerClient();

    /**
     * 保存成功后返回fastdfs上面的路径
     * @param file
     * @return
     */
    public static String fileUpload(byte[] file){
        TrackerServer trackerServer;
        StorageServer storageServer=null;
        String backUrl=null;
        try {
            trackerServer=trackerClient.getConnection();
            StorageClient storageClient=new StorageClient(trackerServer, storageServer);
            String[] strs = storageClient.upload_file(file,null,null);
            backUrl = strs[1];
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return backUrl;
    }
}
