package com.cn.gaokao.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.gaokao.common.Result;
import com.cn.gaokao.mapper.LoginMapper;
import com.cn.gaokao.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @since 2021/4/8 19:37
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户注册登录")
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;

    @ApiOperation("用户登录")
    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
                        HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName, username).or().eq(User::getPhone, username);
        User user = loginMapper.selectOne(queryWrapper);
        if (user != null) {
            if (password.equals(user.getUserpwd())) {

            } else {
                return Result.error(101, "密码错误");
            }
        } else {
            return Result.error(102, "用户名错误");
        }
        return Result.success(user);
    }

    @ApiOperation("用户注册")
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result register(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        if (user == null) {
            return Result.error(103, "用户信息不能为空");
        }
        if (StringUtils.isEmpty(user.getName())) {
            return Result.error(104, "用户名不能为空");
        }
        String reges = "^[1][3,4,5,7,8][0-9]{9}$";
        if (!Pattern.compile(reges).matcher(String.valueOf(user.getPhone())).matches()) {
            return Result.error(105, "电话号格式有误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName, user.getName());
        if (loginMapper.selectOne(queryWrapper) != null) {
            return Result.error(106, "用户名已存在");
        }
        queryWrapper.clear();
        queryWrapper.lambda().eq(User::getPhone, user.getPhone());
        if (loginMapper.selectOne(queryWrapper) != null) {
            return Result.error(107, "电话号码已存在");
        }
        return Result.success(loginMapper.insert(user));
    }
}
