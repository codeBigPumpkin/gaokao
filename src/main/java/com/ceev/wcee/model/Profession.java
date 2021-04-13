package com.ceev.wcee.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Administrator
 * @since 2021/4/13 16:52
 */
@Data
@TableName("tbl_profession")
public class Profession {
    /**
     * 主键id配置编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    /**
     * 专业名称
     */
    private String name;
    /**
     * 专业类型(本科\专科\哲学\经济学\法学等)
     */
    private String type;
    /**
     * 专业描述
     */
    private String description;
    /**
     * 所属专业父专业
     */
    private int pid;
}
