package com.wzw.flower.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wzw
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flower {
    /**
     * 主键
     */
    @Id
    private String flowerId;

    /**
     * 花名
     */
    @Column
    private String name;

    /**
     * 市场价格 黑色字体
     */
    @Column
    private Double marketPrice;

    /**
     * 特价 灰色字体
     */
    @Column
    private Double specialPrice;

    /**
     * 图片
     */
    @Column
    private String image;

    /**
     * 是否热卖
     */
    @Column
    private Integer isHot;

    /**
     * 介绍
     */
    @Column
    private String description;

    /**
     * 上架时间
     */
    @Column
    private Date createTime;

    /**
     * 库存
     */
    @Column
    private Integer stock;

    /**
     * 已售
     */
    @Column
    private Integer num;

    /**
     * 星星指数
     */
    @Column
    private Integer stars;

    /**
     * 属于什么品种
     */
    @Column
    private String typeCategoryId;

    /**
     * 属于什么颜色
     */
    @Column
    private String colorCategoryId;

    /**
     * 属于什么地区
     */
    @Column
    private String areaCategoryId;

    /**
     * 属于什么特殊含义
     */
    @Column
    private String meaningCategoryId;
}