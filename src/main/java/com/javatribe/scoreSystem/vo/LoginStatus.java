package com.javatribe.scoreSystem.vo;

import com.javatribe.scoreSystem.entity.Judge;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/18 10:17
 */

public class LoginStatus {
    private int status;
    private String token;
    private String message;
    private Judge judge;

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(int flag) {
        this.message = flag == 1 ? "" : "用户名或密码错误！";
    }
}
