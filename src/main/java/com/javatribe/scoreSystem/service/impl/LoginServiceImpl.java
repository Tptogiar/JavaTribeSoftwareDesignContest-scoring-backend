package com.javatribe.scoreSystem.service.impl;

import com.javatribe.scoreSystem.dao.LoginMapper;
import com.javatribe.scoreSystem.entity.Judge;
import com.javatribe.scoreSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/16 22:33
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int checkName(Judge judge) {
        return loginMapper.checkLogin(judge);
    }

    @Override
    public Judge getJudge(Judge judge) {
        return loginMapper.getJudge(judge);
    }
}
