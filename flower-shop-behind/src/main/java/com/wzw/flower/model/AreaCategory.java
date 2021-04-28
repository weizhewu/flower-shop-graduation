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
 * @Date: 2021/4/21 14:00
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "area_category")
public class AreaCategory {
    /**
     * 主键
     */
    @Id
    private String areaCategoryId;

    /**
     * 所属地区名字
     */
    @Column
    private String name;
}
