package org.pussinboots.morning.product.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.product.entity.FileModel;

import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-09
 */
public interface FileMapper extends BaseMapper<FileModel> {

    Integer insertFile(@Param("fileModel") FileModel fileModel );

    List<FileModel> getImageListByLoginName(@Param("loginName") String loginName,
                                            @Param("offset") Integer offset,
                                            @Param("limit") Integer limit);

    Integer getListTotal(@Param("loginName") String loginName);
}
