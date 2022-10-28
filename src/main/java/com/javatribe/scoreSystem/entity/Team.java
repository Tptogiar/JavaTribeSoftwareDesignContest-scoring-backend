package com.javatribe.scoreSystem.entity;


public class Team {

    private long id;
    private String teamName;
    private long teamStatus; // 0 上场， 1 下场
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public int getCanMark() {
        return canMark;
    }

    public void setCanMark(int canMark) {
        this.canMark = canMark;
    }

    private int canMark; // 0 可以评分， 1 不可以评分


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public long getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(long teamStatus) {
        this.teamStatus = teamStatus;
    }

}
