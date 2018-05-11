package org.pussinboots.morning.os.common.cache.index;

import org.pussinboots.morning.online.entity.AdvertDetail;
import org.pussinboots.morning.online.entity.NavigationBar;

import java.io.Serializable;
import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-05
 * 用于封装首页缓存的数据缓存类（广告的缓存）
 * 由于广告缓存先做的命名上面没有遵循规范
 */
public class IndexCacheAdDto implements Serializable {


    //标题栏
    private List<NavigationBar> indexAdvertLeft;

    //推荐商品（轮播图）
    private List<AdvertDetail> indexCarouselImgs;

    //热点商品
    private List<AdvertDetail> indexHotAdvertImgs;


    public List<NavigationBar> getIndexAdvertLeft() {
        return indexAdvertLeft;
    }

    public void setIndexAdvertLeft(List<NavigationBar> indexAdvertLeft) {
        this.indexAdvertLeft = indexAdvertLeft;
    }

    public List<AdvertDetail> getIndexCarouselImgs() {
        return indexCarouselImgs;
    }

    public void setIndexCarouselImgs(List<AdvertDetail> indexCarouselImgs) {
        this.indexCarouselImgs = indexCarouselImgs;
    }

    public List<AdvertDetail> getIndexHotAdvertImgs() {
        return indexHotAdvertImgs;
    }

    public void setIndexHotAdvertImgs(List<AdvertDetail> indexHotAdvertImgs) {
        this.indexHotAdvertImgs = indexHotAdvertImgs;
    }

}
