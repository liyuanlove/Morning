package org.pussinboots.morning.product.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * Create by ZengShiLin on 2018-02-13
 * 分类树的数据体
 */
public class CategoryTree extends Model<CategoryTree> {

    //节点ID
    String id;

    //父亲节点ID
    String pId;

    //节点名称
    String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
