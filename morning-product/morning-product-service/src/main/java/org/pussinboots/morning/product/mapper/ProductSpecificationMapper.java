package org.pussinboots.morning.product.mapper;

import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.product.entity.ProductSpecification;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * 
* 项目名称：morning-product-service   
* 类名称：ProductSpecificationMapper   
* 类描述：ProductSpecification / 商品规格表 数据访问层接口       
* 创建人：陈星星   
* 创建时间：2017年4月14日 上午2:05:20   
*
 */
public interface ProductSpecificationMapper extends BaseMapper<ProductSpecification> {
	
	/**
	 * 根据商品ID、规格状态、是否默认查找商品规格
	 * @param productId 商品ID
	 * @param status 规格状态
	 * @param defaultStatus 是否默认
	 * @return
	 */
	ProductSpecification getByStatus(@Param("productNumber") String productNumber, @Param("status") Integer status,
			@Param("defaultStatus") Integer defaultStatus);

	Integer insert(@Param("speID") Long speID,@Param("productNumber") String productNumber,
				   @Param("stock") Integer stock,
				   @Param("price") BigDecimal price,
				   @Param("score") Integer score,
				   @Param("userName") String userName);
}