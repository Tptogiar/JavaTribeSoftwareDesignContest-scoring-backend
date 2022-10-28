package com.javatribe.scoreSystem.controller;

import com.javatribe.scoreSystem.cache.ResultCache;
import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.entity.Score;
import com.javatribe.scoreSystem.entity.Team;
import com.javatribe.scoreSystem.service.JudgeService;
import com.javatribe.scoreSystem.service.ResultService;
import com.javatribe.scoreSystem.utils.JSONUtil;
import com.javatribe.scoreSystem.vo.BackTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/17 15:51
 */

@Controller
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;
    @Autowired
    private ResultService resultService;

    /**
     * 有得分队伍
     * @param map
     * @return
     */
    @ResponseBody
    @PostMapping("/getNoScoreTeam")
    public List<Team> getNoScoreTeam(@RequestBody Map<String, Integer> map) {
        List<Team> teams = judgeService.noScoreTeam(map);
//        String json = JSONUtil.toJSON(teams);
        return teams;
    }

    /**
     * 无得分队伍
     * @param map
     * @return
     */
    @ResponseBody
    @PostMapping("/getHasScoreTeam")
    public List<Result> getHasScoreTeam(@RequestBody Map<String, Integer> map) {
        List<Result> results = null;
        try{
            results =  judgeService.hasScoreTeam(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return results;
    }

    @ResponseBody
    @PostMapping("/insertScore")
    public BackTo insertScore(@RequestBody Score score) {

        try{
            int result = judgeService.insertScore(score);
            if (1 == result) {
                ResultCache.resultCache = resultService.getResultSet();
                return new BackTo("评分成功！", 200);
            } else {
                return new BackTo("该队伍暂时禁止评分！", 5000);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BackTo("评分异常！", 5000);
        }

    }

    @ResponseBody
    @PostMapping("/updateScore")
    public BackTo updateScore(@RequestBody Score score) {
        try {
            int result = judgeService.updateScore(score);
            if (1 == result) {
                ResultCache.resultCache = resultService.getResultSet();
                return new BackTo("已修改评分！", 200);
            } else {
                return new BackTo("该队伍暂时禁止评分！", 5000);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BackTo("修改评分异常", 5000);
        }

    }

    @ResponseBody
    @PostMapping("/updateStatus")
    public BackTo updateStatus(@RequestBody Team team) {
        try {
            int result = judgeService.updateStatus(team);
            if (1 == result) {
                if(team.getTeamStatus() == 0){
                    return new BackTo("该队伍已改为上场状态！", 200);
                }
                return new BackTo("该队伍已改为下场状态！", 200);

            } else {
                return new BackTo("操作失败！请刷新重试", 5000);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BackTo("操作异常", 5000);
        }

    }

    @ResponseBody
    @PostMapping("/updateCanMark")
    public BackTo updateCanMark(@RequestBody Team team) {
        try {
            int result = judgeService.updateCanMark(team);
            System.out.println("更新评分状态");
            if (1 == result) {
                if(team.getCanMark() == 0){
                    return new BackTo("该队伍已改为可评分状态！", 200);
                }
                return new BackTo("该队伍已改为禁止评分状态！", 200);
            } else {
                return new BackTo("操作失败！请刷新重试", 5000);
            }
        }catch (Exception e){
            return new BackTo("操作异常！", 5000);
        }

    }


//    获取所有队伍
    @GetMapping("/getAllTeams")
    @ResponseBody
    public List<Team> getAllTeams(){
        try {
            return  judgeService.getAllTeams();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
