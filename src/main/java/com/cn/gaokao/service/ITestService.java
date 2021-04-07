package com.cn.gaokao.service;


import java.util.List;

/**
 * @author yanyan
 */
public interface ITestService {
    Object findAllConfig(int pageNum, int pageSize);
    Object getSecurityScreenConfigById();
    List selectAll();
}
