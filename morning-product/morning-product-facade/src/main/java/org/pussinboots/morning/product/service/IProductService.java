package org.pussinboots.morning.product.service;

import org.pussinboots.morning.product.entity.Product;
import org.pussinboots.morning.product.pojo.vo.ProductVO;

import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 
* 项目名称：morning-product-facade   
* 类名称：IProductService   
* 类描述：Product / 商品表 业务逻辑层接口          
* 创建人：陈星星   
* 创建时间：2017年4月11日 下午3:13:06   
*
 */
public interface IProductService extends IService<Product> {
	
	/**
	 * 根据商品编号和状态查找商品
	 * @param productNumber 商品编号
	 * @param status 状态
	 * @return
	 */
	ProductVO getByNumber(String productNumber, Integer status);

	ProductVO getProductByNumber(String productNumber);

	String getProductDescription(String productNumber);

	List<ProductVO> getAllProduct(Integer offset,Integer limit);

	Integer getAllProductTotal();

	Integer insertProduct(Product product, String description, String userName, Integer categoryID, Integer stock, MultipartFile files);

	/**
	 * 更新商品冻结状态
	 * @param productNumber
	 * @param type
	 * @return
	 */
	boolean updateProductFrozen(String productNumber,Integer type);

	/**
	 * 判断商品是否冻结
	 * @param productNumber
	 * @return
	 */
	boolean productIsForzen(String productNumber);



	
}
