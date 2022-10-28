package com.javatribe.scoreSystem.controller;

import com.javatribe.scoreSystem.cache.LoginCache;
import com.javatribe.scoreSystem.entity.Judge;
import com.javatribe.scoreSystem.service.impl.LoginServiceImpl;
import com.javatribe.scoreSystem.utils.JSONUtil;
import com.javatribe.scoreSystem.utils.TokenFactory;
import com.javatribe.scoreSystem.vo.BackTo;
import com.javatribe.scoreSystem.vo.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/16 22:11
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @ResponseBody
    @PostMapping("/checkName")
    public LoginStatus checkName(@RequestBody Judge judge) {
        try {
            int result = loginService.checkName(judge);
            LoginStatus loginStatus = new LoginStatus();
            if (result == 1) {
                loginStatus.setStatus(200);
                loginStatus.setMessage(result);
                judge = loginService.getJudge(judge);
                judge.setJudgePassword("xxxx");
                loginStatus.setJudge(judge);
                String token = TokenFactory.token(judge.getJudgeName(), judge.getJudgePassword());
                LoginCache.add(token, (int) judge.getId());
                loginStatus.setToken(token);
            } else {
                loginStatus.setStatus(1001);
                loginStatus.setMessage(result);
            }
            return loginStatus;
        }catch (Exception e){
            e.printStackTrace();
            return new LoginStatus();
        }
    }

    @ResponseBody
    @PostMapping("/logout")
    public BackTo logout(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            int result = LoginCache.removeId(token);
            BackTo backTo = new BackTo();
            if (result == 1) {
                backTo.setCode(200);
                backTo.setMessage("已经清除登录痕迹！");
            } else {
                backTo.setCode(5000);
                backTo.setMessage("登录痕迹清除失败！");
            }
            return backTo;
        }catch (Exception e){
            e.printStackTrace();
            return new BackTo("操作异常", 5000);
        }
    }
}
