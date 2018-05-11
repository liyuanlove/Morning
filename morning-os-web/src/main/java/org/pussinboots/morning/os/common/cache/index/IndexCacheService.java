package org.pussinboots.morning.os.common.cache.index;

import org.pussinboots.morning.online.common.enums.AdvertTypeEnum;
import org.pussinboots.morning.online.common.enums.NavigationBarTypeEnum;
import org.pussinboots.morning.online.service.IAdvertDetailService;
import org.pussinboots.morning.online.service.INavigationBarService;
import org.pussinboots.morning.product.common.constant.CategoryConstantEnum;
import org.pussinboots.morning.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by ZengShiLin on 2018-02-05
 * 广告缓存业务（这里缓存广告）
 * 由于广告缓存先做的命名上面没有遵循规范
 */
@Service
public class IndexCacheService {

    @Autowired
    private IndexCacheDao indexCacheDao;
    @Autowired
    private IAdvertDetailService advertDetailService;
    @Autowired
    private INavigationBarService navigationBarService;
    @Autowired
    private ICategoryService categoryService;

    /**
     * 获取广告缓存业务
     *
     */
    public IndexCacheAdDto getIndexAdCache(){
        IndexCacheAdDto indexAdCacheDto = indexCacheDao.getIndexCacheAd();
        //如果redis的缓存为空就直接去查询数据库（缓存时间为30分钟）
        if(indexAdCacheDto == null){
            indexAdCacheDto = new IndexCacheAdDto();
            indexAdCacheDto.setIndexHotAdvertImgs(advertDetailService
                    .listByAdvertId(AdvertTypeEnum.INDEX_HOT_ADVERT.getType()));

            indexAdCacheDto.setIndexCarouselImgs(advertDetailService
                    .listByAdvertId(AdvertTypeEnum.INDEX_CAROUSEL.getType()));

            indexAdCacheDto.setIndexAdvertLeft(navigationBarService
                    .listByNavigationId(NavigationBarTypeEnum.INDEX_ADVERT_LEFT.getType()));
            indexCacheDao.putIndexCacheAd(indexAdCacheDto);
        }
        return indexAdCacheDto;
    }

    /**
     * 获取导航栏缓存
     *
     */
    public IndexCacheNaDto getIndexNaCache(){
        IndexCacheNaDto indexCacheNaDto = indexCacheDao.getIndexNache();
        if(indexCacheNaDto == null){
            indexCacheNaDto = new IndexCacheNaDto();

            indexCacheNaDto.setIndexClassify(navigationBarService
                    .listByNavigationId(NavigationBarTypeEnum.INDEX_CLASSIFY.getType()));

            indexCacheNaDto.setIndexBottom(navigationBarService
                    .listByNavigationId(NavigationBarTypeEnum.INDEX_BOTTOM.getType()));

            indexCacheNaDto.setIndexTop(navigationBarService
                    .listByNavigationId(NavigationBarTypeEnum.INDEX_TOP.getType()));
            indexCacheDao.putIndexCacheNa(indexCacheNaDto);
        }
        return indexCacheNaDto;
    }

    /**
     * 获取商品分类缓存
     *
     */
    public IndexCacheCaDto getIndexCaCache(){
        IndexCacheCaDto indexCacheCaDto = indexCacheDao.getIndexCacheCa();
        if(indexCacheCaDto == null){
            indexCacheCaDto = new IndexCacheCaDto();
            indexCacheCaDto.setCategorys(categoryService.listNav(CategoryConstantEnum.CATEGORY_NAV_PRODUCT.getValue(),
                    CategoryConstantEnum.CATEGORY_NAV_NUMBER.getValue()));

            indexCacheDao.putIndexCacheCa(indexCacheCaDto);
        }
        return indexCacheCaDto;
    }




}
