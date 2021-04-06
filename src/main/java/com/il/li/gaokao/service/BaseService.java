package com.il.li.gaokao.service;

import com.il.li.gaokao.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    private BaseDao baseDao;

}
