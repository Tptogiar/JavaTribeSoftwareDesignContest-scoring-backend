package com.javatribe.scoreSystem.controller;

import com.javatribe.scoreSystem.cache.ResultCache;
import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.service.ResultService;
import com.javatribe.scoreSystem.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/17 15:27
 */

@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @ResponseBody
    @PostMapping("/getResult")
    public List<Result> getResult() {
        try{
            List<Result> results = ResultCache.resultCache;
            return results;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @GetMapping("/update")
    public List<Result> updateCache() {
        try {
            ResultCache.resultCache = resultService.getResultSet();
            return ResultCache.resultCache;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
