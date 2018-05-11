package org.pussinboots.morning.os.common.cache.index;

import org.pussinboots.morning.product.pojo.vo.CategoryVO;

import java.io.Serializable;
import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-05
 * 主页的分类和商品列表缓存数据体
 */
public class IndexCacheCaDto implements Serializable{

    private  List<CategoryVO> categorys;


    public List<CategoryVO> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryVO> categorys) {
        this.categorys = categorys;
    }
}
