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
 * @Description: 品种分类
 * @Author: wzw
 * @Date: 2021/4/21 11:25
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_category")
public class TypeCategory {
    /**
     * 主键
     */
    @Id
    private String typeCategoryId;

    /**
     * 种类名字
     */
    @Column
    private String name;
}
