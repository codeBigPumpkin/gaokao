package com.cn.gaokao.service;

import com.cn.gaokao.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    private BaseDao baseDao;

}
