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
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 9:14
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meaning_category")
public class MeaningCategory {
    /**
     * 主键
     */
    @Id
    private String meaningCategoryId;

    /**
     * 特殊含义名称
     */
    @Column
    private String name;
}
