package com.ceev.wcee.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;


public class Result extends JSONObject {
    private static final long serialVersionUID = 1L;

    public Result() {
        put(Constants.R_STATUS, 0);
        put(Constants.R_MSG, "成功");
        put(Constants.R_DATA, null);
    }

    public static Result error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put(Constants.R_STATUS, code);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, null);
        return result;
    }

    public static Result error(int code, String msg, Object data) {
        Result result = new Result();
        result.put(Constants.R_STATUS, code);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, data);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put(Constants.R_STATUS, 0);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, null);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.put(Constants.R_STATUS, 0);
        result.put(Constants.R_MSG, "成功");
        result.put(Constants.R_DATA, data);
        return result;
    }

    public static Result success(int status, String msg) {
        Result result = new Result();
        result.put(Constants.R_STATUS, status);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, null);
        return result;
    }

    public static Result success(int status, String msg, Object data) {
        Result result = new Result();
        result.put(Constants.R_STATUS, status);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, data);
        return result;
    }

    public static Result success(int status, String msg, Object data, String sid) {
        Result result = new Result();
        result.put(Constants.R_STATUS, status);
        result.put(Constants.R_MSG, msg);
        result.put(Constants.R_DATA, data);
        result.put(Constants.R_SID, sid);
        return result;
    }

    public static Result success() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
