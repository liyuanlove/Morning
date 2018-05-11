package org.pussinboots.morning.os.common.cache.index;

import org.pussinboots.morning.online.entity.NavigationBar;

import java.util.List;

/**
 * Create by ZengShiLin on 2018-02-05
 * 主页导航栏缓存数据体
 */
public class IndexCacheNaDto {

    private List<NavigationBar> indexTop;

    private List<NavigationBar> indexBottom;

    private  List<NavigationBar> indexClassify;

    public List<NavigationBar> getIndexTop() {
        return indexTop;
    }

    public void setIndexTop(List<NavigationBar> indexTop) {
        this.indexTop = indexTop;
    }

    public List<NavigationBar> getIndexBottom() {
        return indexBottom;
    }

    public void setIndexBottom(List<NavigationBar> indexBottom) {
        this.indexBottom = indexBottom;
    }

    public List<NavigationBar> getIndexClassify() {
        return indexClassify;
    }

    public void setIndexClassify(List<NavigationBar> indexClassify) {
        this.indexClassify = indexClassify;
    }
}
