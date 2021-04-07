package com.cn.gaokao.service;

import java.util.Map;

public interface ITestService {
    Object findAllConfig(int pageNum, int pageSize);

    Object getSecurityScreenConfigById();

    Map selectAll();
}
