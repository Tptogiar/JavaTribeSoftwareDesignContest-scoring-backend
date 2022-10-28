package com.javatribe.scoreSystem.dao;

import com.javatribe.scoreSystem.entity.Judge;


public interface LoginMapper {
    int checkLogin(Judge judge);

    Judge getJudge(Judge judge);
}
