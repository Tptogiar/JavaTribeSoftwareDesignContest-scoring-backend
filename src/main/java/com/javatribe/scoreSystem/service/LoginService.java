package com.javatribe.scoreSystem.service;

import com.javatribe.scoreSystem.entity.Judge;

public interface LoginService {
    int checkName(Judge judge);

    Judge getJudge(Judge judge);
}

