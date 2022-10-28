package com.javatribe.scoreSystem.vo;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/24 19:30
 */

public class BackTo {
    private String message;
    private int code;
    public BackTo(){}

    @Override
    public String toString() {
        return "BackTo{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    public BackTo(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
