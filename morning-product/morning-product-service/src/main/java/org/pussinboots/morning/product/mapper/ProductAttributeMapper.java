package org.pussinboots.morning.product.mapper;

import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.product.entity.ProductAttribute;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
* 项目名称：morning-product-service   
* 类名称：ProductAttributeMapper   
* 类描述：ProductAttribute / 商品属性表 数据访问层接口      
* 创建人：南蛮麟爷
*
 */
public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {
    Integer insert(@Param("productNumber") String productNumber,@Param("stock") Integer stock);
}