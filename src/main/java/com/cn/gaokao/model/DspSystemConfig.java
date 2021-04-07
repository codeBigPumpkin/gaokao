package com.cn.gaokao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class DspSystemConfig {

    /**
     * 主键id配置编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 配置编码
     */
    private String dspCfgCode;

    /**
     * 配置名称
     */
    private String dspCfgName;

    /**
     * 配置描述
     */
    private String dspCfgDesc;

    /**
     * 配置值类型，比如integer（整数）、html（HTML）等bool（是否），不同的值类型可以通过不同的表单来显示和编辑
     */
    private String dspCfgValueType;

    /**
     * 配置值
     */
    private String dspCfgValue;

    /**
     * dsp_cfg_state
     */
    private String dspCfgState;
}
