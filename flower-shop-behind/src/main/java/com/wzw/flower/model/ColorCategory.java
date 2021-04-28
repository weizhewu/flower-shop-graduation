package com.wzw.flower.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 颜色分类
 * @Author: wzw
 * @Date: 2021/4/21 13:58
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color_category")
public class ColorCategory {
    /**
     * 主键
     */
    @Id
    private String colorCategoryId;

    /**
     * 颜色名字
     */
    @Column
    private String name;
}
