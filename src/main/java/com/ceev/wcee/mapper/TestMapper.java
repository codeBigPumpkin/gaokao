package com.ceev.wcee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceev.wcee.model.DspSystemConfig;

import java.util.Map;

public interface TestMapper extends BaseMapper<DspSystemConfig> {
    Map selectAllfdfs();
}
