package cn.henghuasoft.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 *
 * </p>
 *
 * @author Jarvis-Smith
 * @since 2023-08-29
 */
@Data
@Entity
@Table(name = "t_spring_security_user")
public class SpringSecurityUser {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    private Long id;
    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 账号状态 0 正常 1 停用
     */
    @Column(name = "status")
    private String status;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 手机号
     */
    @Column(name = "phoneNumber")
    private String phoneNumber;
    /**
     * 性别 0 男 1 女 2 未知
     */
    @Column(name = "sex")
    private String sex;
    /**
     * 用户类型 0 管理员 1 用户
     */
    @Column(name = "userType")
    private String userType;
    /**
     * 0 未删除 1 删除
     */
    @Column(name = "deleteFlag")
    private Integer deleteFlag;
}
