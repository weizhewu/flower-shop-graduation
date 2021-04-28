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
 * @Description: 用于界面图片的更改
 * @Author: wzw
 * @Date: 2021/4/22 10:36
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cover")
public class Cover {
    /**
     * 主键
     */
    @Id
    private String coverId;

    /**
     * 所属类别
     */
    @Column
    private String type;

    /**
     * 鲜花标识
     */
    @Column
    private String name;

    /**
     * 鲜花图片地址
     */
    @Column
    private String src;
}
