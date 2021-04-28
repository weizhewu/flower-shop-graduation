package com.wzw.flower.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 9:26
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "update user set is_deleted = 1 where user_id = ?")
@Where(clause = "is_deleted = 0")
@Table(name = "user")
public class User {
    /**
     * 主键
     */
    @Id
    private String userId;

    /**
     * 用户昵称
     */
    @Column
    private String nickName;

    /**
     * 用户账号
     */
    @Column(unique = true)
    private String account;

    /**
     * 用户密码
     */
    @Column
    private String password;

    /**
     * 用户手机号
     */
    @Column
    private String phone;

    /**
     * 用户签名
     */
    @Column
    private String sign;

    /**
     * 用户头像
     */
    @Column
    private String image;

    /**
     * 用户地址
     */
    @Column
    private String address;

    /**
     * 是否已删除 0：未删除 1：已删除
     */
    @Column
    private Integer isDeleted;
}
