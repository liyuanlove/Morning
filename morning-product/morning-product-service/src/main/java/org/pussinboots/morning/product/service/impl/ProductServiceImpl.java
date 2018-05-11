package org.pussinboots.morning.product.service.impl;

import org.pussinboots.morning.product.entity.Product;
import org.pussinboots.morning.product.entity.ProductCategory;
import org.pussinboots.morning.product.mapper.*;
import org.pussinboots.morning.product.pojo.vo.ProductVO;
import org.pussinboots.morning.product.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.pussinboots.morning.product.util.FastdfsUtil;
import org.pussinboots.morning.product.util.UUidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 
* 项目名称：morning-product-service   
* 类名称：ProductServiceImpl   
* 类描述：Product / 商品表 业务逻辑层接口实现        
* 创建人：陈星星   
* 创建时间：2017年4月11日 下午3:17:31   
*
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	@Autowired
	private ProductDetailMapper productDetailMapper;
	@Autowired
	private ProductAttributeMapper productAttributeMapper;
	@Autowired
	private ProductSpecificationMapper productSpecificationMapper;
	@Autowired
	private ProductImageMapper productImageMapper;

	@Override
	public ProductVO getByNumber(String productNumber, Integer status) {
		return productMapper.getByNumber(productNumber, status);
	}

	@Override
	public ProductVO getProductByNumber(String productNumber) {
		return productMapper.getProductByNumber(productNumber);
	}

	@Override
	public String getProductDescription(String productNumber) {
		return productMapper.getProductDescription(productNumber);
	}

	@Override
	public List<ProductVO> getAllProduct(Integer offset, Integer limit) {
		return productMapper.getAllProduct(offset,limit);
	}

	@Override
	public Integer getAllProductTotal() {
		return productMapper.getAllProductTotal();
	}



	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer insertProduct(Product product,
								 String description,
								 String userName,
								 Integer categoryID,
								 Integer stock,
								 MultipartFile files)throws RuntimeException {

		//为0的是没有加入分类的商品
		if(categoryID==null || categoryID==0){
			categoryID=0;
		}
		//获取指定的业务ID
		product.setProductNumber(UUidUtils.getTimeId(categoryID));
		Long speID = UUidUtils.getIntegerID();
		try {
			String tempurl =  FastdfsUtil.fileUpload(files.getBytes());
			String[] saveUrl = tempurl.split("M00");
			//对商品的各个关联表进行插入
			productMapper.insert(product,description,userName,saveUrl[1]);
			productCategoryMapper.insert(product.getProductNumber(),categoryID,userName);
			productDetailMapper.insert(product.getProductNumber(),description,userName);
			productAttributeMapper.insert(product.getProductNumber(),stock);
			productSpecificationMapper.insert(speID,product.getProductNumber(),stock,product.getShowPrice(),product.getShowScore(),userName);
			productImageMapper.insert(product.getProductNumber(),saveUrl[1],userName);
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("商品保存异常");
		}
		return null;
	}


	/**
	 * 更新商品冻结状态
	 */
	@Transactional
	@Override
	public boolean updateProductFrozen(String productNumber, Integer type) {

		if(productNumber==null || productNumber.equals("") || type==null ){
			return false;
		}

		productMapper.updateProductFrozen(productNumber,type);

		return false;
	}

	/**
	 * 判断商品是否冻结
	 * @param productNumber
	 * @return
	 */
	@Override
	public boolean productIsForzen(String productNumber) {
		try {
			Integer flag = productMapper.getProductForzen(productNumber);
			if(flag != null){
				if(flag==1){
					return true;
				}
			}else {
				return false;
			}
			return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


}
