package org.pussinboots.morning.product.service;

import com.baomidou.mybatisplus.service.IService;
import org.pussinboots.morning.product.entity.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-09
 */
public interface IFileService extends IService<FileModel> {

    public boolean saveFile(String loginName,MultipartFile[] imagefiles);

    public List<FileModel> getImageListByLoginName(String loginName,Integer offset,Integer limit);

    public Integer getListTotal(String loginName);
}
