package com.cn.gaokao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.gaokao.model.DspSystemConfig;

import java.util.Map;

public interface TestMapper extends BaseMapper<DspSystemConfig> {
    Map selectAllfdfs();
}
