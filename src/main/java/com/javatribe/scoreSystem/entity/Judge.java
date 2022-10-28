package com.javatribe.scoreSystem.entity;


public class Judge {

    private long id;
    private String judgeName;
    private String judgePassword;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }


    public String getJudgePassword() {
        return judgePassword;
    }

    public void setJudgePassword(String judgePassword) {
        this.judgePassword = judgePassword;
    }

}
