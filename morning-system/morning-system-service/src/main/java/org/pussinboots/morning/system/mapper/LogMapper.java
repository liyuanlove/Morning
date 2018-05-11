package org.pussinboots.morning.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.system.entity.Log;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
* 项目名称：morning-system-service   
* 类名称：LogMapper   
* 类描述：LogMapper / 日志记录表 数据访问层接口      
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午10:25:26   
*
 */
public interface LogMapper extends BaseMapper<Log> {
	
	/**
	 * 根据分页信息/搜索内容查找日志记录列表
	 * @param pageInfo 分页信息
	 * @param search 搜索内容
	 * @param page 分页实体
	 * @return
	 */
	List<Log> listByPage(@Param("pageInfo") PageInfo pageInfo, @Param("search") String search, RowBounds rowBounds);

}