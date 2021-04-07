package com.cn.gaokao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.gaokao.pojo.DspSystemConfig;

import java.util.List;

/**
 * @author yanyan
 */
public interface TestMapper extends BaseMapper<DspSystemConfig> {
    List selectAllfdfs();
}
