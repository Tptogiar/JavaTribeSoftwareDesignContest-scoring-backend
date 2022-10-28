package com.javatribe.scoreSystem.entity;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/17 14:45
 */

public class Result {
    private int teamId;
    private String teamName;
    private Long teamStatus;
    private String projectName;
    private double mark;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }


    public Long getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(Long teamStatus) {
        this.teamStatus = teamStatus;
    }
}
