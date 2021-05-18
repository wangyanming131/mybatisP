package com.example.demo.constant;

import java.io.Serializable;

/**
 * 返回结果统一封装
 */
public class ResultInfo implements Serializable {

    // 状态码
    private Integer code;
    // 消息
    private String message;
    // 数据对象
    private Object result;

    private Integer total;

    /**
     * 无参构造器
     */
    public ResultInfo() {
        super();
    }

    public ResultInfo(Status status) {
        super();
        this.code = status.code;
        this.message = status.message;
    }

    public ResultInfo result(Object result) {
        this.result = result;
        return this;
    }

    public ResultInfo message(String message) {
        this.message = message;
        return this;
    }

    public ResultInfo total(Integer total) {
        this.total = total;
        return this;
    }

    /**
     * 只返回状态，状态码，消息
     *
     * @param code
     * @param message
     */
    public ResultInfo(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 只返回状态，状态码，数据对象
     *
     * @param code
     * @param result
     */
    public ResultInfo(Integer code, Object result) {
        super();
        this.code = code;
        this.result = result;
    }

    /**
     * 返回全部信息即状态，状态码，消息，数据对象
     *
     * @param code
     * @param message
     * @param result
     */
    public ResultInfo(Integer code, String message, Object result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
