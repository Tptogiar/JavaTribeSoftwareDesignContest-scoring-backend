package com.javatribe.scoreSystem.service.impl;

import com.javatribe.scoreSystem.dao.JudgeMapper;
import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.entity.Score;
import com.javatribe.scoreSystem.entity.Team;
import com.javatribe.scoreSystem.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/26 23:07
 */

@Service
public class JudgeServiceImpl implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;

    @Override
    public List<Team> noScoreTeam(Map<String, Integer> map) {
        return judgeMapper.noScoreTeam(map);
    }

    @Override
    public List<Result> hasScoreTeam(Map<String, Integer> map) {
        return judgeMapper.hasScoreTeam(map);
    }

    @Override
    public int insertScore(Score score) {
        // 判断是否可以评分
        if(this.judgeMapper.selectCanMark(score.getTeamId()) == 0){
            // 禁止重复评分
            if(this.judgeMapper.isMarked(score) == 0){
                return judgeMapper.insertScore(score);
            }
        }
        return 0;
    }

    @Override
    public int updateScore(Score score) {
        // 判断是否可以评分
        if(this.judgeMapper.selectCanMark(score.getTeamId()) == 0) {
            // 评分过才能修改
            if(this.judgeMapper.isMarked(score) == 1){
                return judgeMapper.updateScore(score);
            }
        }
        return 0;
    }

    @Override
    public int updateStatus(Team team) {
        return judgeMapper.updateStatus(team);
    }

    @Override
    public int updateCanMark(Team team) {
        return judgeMapper.updateCanMark(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return judgeMapper.selectAllTeams();
    }
}
