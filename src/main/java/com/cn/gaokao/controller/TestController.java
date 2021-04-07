package com.cn.gaokao.controller;

import com.cn.gaokao.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanyan
 */
@RestController
@RequestMapping("systemConfig")
@Api(tags = "系统配置")
public class TestController {

    @Resource
    private ITestService testService;

    @ApiOperation("获取所有系统配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query", required = true)})
    @GetMapping("getAll")
    public Object findAllConfig(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return testService.findAllConfig(pageNum, pageSize);
    }

    @GetMapping("getSecurityScreenConfigById")
    public Object getSecurityScreenConfigById() {

        return testService.getSecurityScreenConfigById();
    }

    @GetMapping("selectAll")
    public Object selectAll() {

        return testService.selectAll();
    }
}
