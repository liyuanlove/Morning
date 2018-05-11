package org.pussinboots.morning.product.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.pussinboots.morning.product.entity.FileModel;
import org.pussinboots.morning.product.mapper.FileMapper;
import org.pussinboots.morning.product.service.IFileService;
import org.pussinboots.morning.product.util.FastdfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-09
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper,FileModel> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean saveFile(String loginName,MultipartFile[] imagefiles)throws RuntimeException{
        boolean flag = true;
        for(MultipartFile temp : imagefiles){
            try {
                String fileName = temp.getOriginalFilename();
                String str = FastdfsUtil.fileUpload(temp.getBytes());
                //先写死，因为nginx还没办法配置location
                String[] saveUrl = str.split("M00");
                FileModel fileModel = new FileModel();
                fileModel.setFileUrl(saveUrl[1]);
                fileModel.setFileName(fileName);
                fileModel.setCreateUser(loginName);
                fileMapper.insertFile(fileModel);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            } catch (RuntimeException e){
                flag = false;
                throw new RuntimeException("主键冲突");
            }
        }
        return flag;
    }



    @Override
    public List<FileModel> getImageListByLoginName(String loginName,Integer offset,Integer limit) {
        return fileMapper.getImageListByLoginName(loginName,offset,limit);
    }


    public Integer getListTotal(String loginName){
        return fileMapper.getListTotal(loginName);
    }
}
