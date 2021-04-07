package com.cn.gaokao.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.gaokao.mapper.TestMapper;
import com.cn.gaokao.pojo.DspSystemConfig;
import com.cn.gaokao.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanyan
 */
@Slf4j
@Component
public class TestServiceImpl implements ITestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public Object findAllConfig(int pageNum, int pageSize) {
        IPage<Map<String, Object>> page = new Page<>(pageNum, pageSize);

        return testMapper.selectMapsPage(page, new QueryWrapper<DspSystemConfig>().orderByDesc("dsp_cfg_name"));
    }

    @Override
    public Object getSecurityScreenConfigById() {
        String code[] = {"csmp", "data", "bsvp"};
        List<DspSystemConfig> configList = new ArrayList<>();
        Arrays.asList(code).stream().forEach(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("dsp_cfg_code", data);
            configList.addAll(testMapper.selectByMap(map));
        });
        return configList.stream().map(data -> data.getDspCfgValue()).collect(Collectors.toList());
    }

    @Override
    public List selectAll() {
        return testMapper.selectAllfdfs();
    }
}
