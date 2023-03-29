package com.laison.softwareproject.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.laison.softwareproject.common.constants.CommonConstant;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lihua
 * @ClassName: R
 * @Description: 返回的数据
 * @date 2017年11月6日 上午9:43:15
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /*
     * private Object data;
     *
     * public Object getData() { return data; }
     *
     * public void setData(Object data) { this.data = data; }
     */
    public static final int NEED_BIND = 466;

    /**
     * 执行中
     */
    private static final int WS_RUNNING = 0;

    /**
     * 失败
     */
    private static final int WS_ERROR = -1;

    /**
     * 执行完成
     */
    private static final int WS_END = 1;

    public Result() {
        put("status", 0);
        put("timestamp", System.currentTimeMillis());
    }

    public static Result error() {
        Result r = new Result();
        r.put("status", 500);
        r.put("success", false);
        return r;
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int status, String msg) {
        Result r = new Result();
        r.put("status", status);
        r.put("success", false);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("status", 0);
        r.put("success", true);
        r.put("msg", msg);
        return r;
    }

    public static Result okData(Object data) {
        Result r = new Result();
        r.put("status", 0);
        r.put("success", true);
        r.put("data", data);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        r.put("status", 0);
        r.put("success", true);
        return r;
    }

    public static Result ok() {
        Result r = new Result();
        r.put("status", 0);
        r.put("success", true);
        return r;
    }

    public static Result BAD_REQUEST(String message) {
        Result r = new Result();
        r.put("status", HttpStatus.BAD_REQUEST.value());
        r.put("success", false);
        r.put("msg", message);
        return r;
    }

    public static Result WS_RUNNING() {
        Result r = new Result();
        r.put("status", 0);
        r.put("operateState", WS_RUNNING);
        return r;
    }

    public static Result WS_END() {
        Result r = new Result();
        r.put("status", 0);
        r.put("operateState", WS_END);
        return r;
    }

    public static Result WS_ERROR() {
        Result r = new Result();
        r.put("status", 0);
        r.put("operateState", WS_ERROR);
        return r;
    }

    public static Map<String, Object> INTERNAL_SERVER_ERROR(String message) {
        Result r = new Result();
        r.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        r.put("msg", message);
        r.put("success", false);
        return r;
    }


    /**
     * 无权限访问返回结果
     */
    public static Result noauth(String msg) {
        return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
    }

    public String getMessage() {
        Object msg = this.get("msg");
        if (msg == null) return null;
        return msg.toString();
    }

    public void setOnlTable(String onlTable) {
        this.put("onlTable", onlTable);
    }

    public String getOnlTable() {
        Object msg = this.get("onlTable");
        if (msg == null) return null;
        return msg.toString();
    }
    public boolean isSuccess() {
        Object msg = this.get("success");
        if (msg == null) return false;
        return (boolean) msg;
    }

    public Object getData() {
        Object data = this.get("data");
        if (data == null) return null;
        return data;
    }
}