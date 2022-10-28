package com.javatribe.scoreSystem.entity;


public class Score {

    private long id;
    private long judgeId;
    private long teamId;
    private double marks;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(long judgeId) {
        this.judgeId = judgeId;
    }


    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }


    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

}
