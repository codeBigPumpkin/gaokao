package com.ceev.wcee.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Administrator
 * @since 2021/4/8 19:29
 */
@Data
@TableName("tbl_user_info")
public class User {
    /**
     * 主键id配置编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 用户密码
     */
    private String userpwd;

    /**
     * 手机号 (登录用)
     */
    private long phone;

    /**
     * 用户类型(会员/艺术/体育/非会员/管理员)
     */
    private int role;

    /**
     * 会员开始时间
     */
    private String startime;

    /**
     * 会员到期时间
     */
    private String endtime;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 会员开始时间
     */
    private String provice;

    /**
     * 分数
     */
    private int score;

    /**
     * 考生类型(理科/文科/艺术/体育)
     */
    private int type;
}
