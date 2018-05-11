package org.pussinboots.morning.product.mapper;

import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.product.entity.Product;
import org.pussinboots.morning.product.pojo.vo.ProductVO;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
* 项目名称：morning-product-service   
* 类名称：ProductMapper   
* 类描述：Product / 商品表 数据访问层接口      
* 创建人：陈星星   
* 创建时间：2017年4月11日 下午3:15:04   
*
 */
public interface ProductMapper extends BaseMapper<Product> {
	
	/**
	 * 根据商品编号和状态查找商品
	 * @param productNumber 商品编号
	 * @param status 状态
	 * @return
	 */
	ProductVO getByNumber(@Param("productNumber") String productNumber, @Param("status") Integer status);


	List<ProductVO> getAllProduct(@Param("offset") Integer offset,@Param("limit") Integer limit);


	Integer getAllProductTotal();


	Integer insert(@Param("product") Product product,
				   @Param("description") String description,
				   @Param("userName") String userName,
				   @Param("picImageUrl") String picImageUrl);

	/**
	 * 更新商品冻结状态
	 * @param productNumber
	 * @param type
	 * @return
	 */
	Integer updateProductFrozen(@Param("productNumber") String productNumber,@Param("type") Integer type);

	/**
	 * 获取商品冻结状态
	 * @param productNumber
	 * @return
	 */
	Integer getProductForzen(@Param("productNumber") String productNumber);


	ProductVO getProductByNumber(@Param("productNumber") String productNumber);

	String getProductDescription(@Param("productNumber") String productNumber);


}