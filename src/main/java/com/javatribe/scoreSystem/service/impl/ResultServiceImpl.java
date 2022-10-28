package com.javatribe.scoreSystem.service.impl;

import com.javatribe.scoreSystem.dao.ResultMapper;
import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/17 15:12
 */

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Override
    public List<Result> getResultSet() {
        return resultMapper.getResultSet();
    }
}
