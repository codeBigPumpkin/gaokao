package com.ceev.wcee.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Administrator
 * @since 2021/4/13 16:47
 */
@Data
@TableName("tbl_college_info")
public class College {
    /**
     * 主键id配置编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    /**
     * 学校名称
     */
    private String name;
    /**
     * 学校地址
     */
    private String address;
    /**
     * 学校省份
     */
    private String province;
    /**
     * 学校所在城市
     */
    private String city;
    /**
     * 学校类型集合
     */
    private String type;
    /**
     * description
     */
    private String 学校介绍;
    /**
     * 学校校徽
     */
    private byte[] ioc;
}
