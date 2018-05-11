package org.pussinboots.morning.product.mapper;

import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.product.entity.ProductDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
* 项目名称：morning-product-service   
* 类名称：ProductDetailMapper   
* 类描述：ProductDetail / 商品描述表 数据访问层接口         
* 修改人：南蛮麟爷
*
 */
public interface ProductDetailMapper extends BaseMapper<ProductDetail> {
    Integer insert(@Param("productNumber") String productNumber,@Param("description") String description,@Param("userName") String userName);
}