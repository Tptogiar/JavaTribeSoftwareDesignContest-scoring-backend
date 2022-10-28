package com.javatribe.scoreSystem.service;

import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.entity.Score;
import com.javatribe.scoreSystem.entity.Team;

import java.util.List;
import java.util.Map;

public interface JudgeService {
    /**
     * 返回某位评委未评分的队伍集合
     *
     * @param map 包含评委id的map
     * @return
     */
    List<Team> noScoreTeam(Map<String, Integer> map);

    /**
     * 返回某位评委已经评委的队伍集合
     *
     * @param map 包含评委id的map
     * @return
     */
    List<Result> hasScoreTeam(Map<String, Integer> map);

    /**
     * 评分
     *
     * @param score 评委ID，队伍ID， 分数
     * @return
     */
    int insertScore(Score score);

    /**
     * 修改评分
     *
     * @param score 评委id， 队伍id，新的分数
     * @return
     */
    int updateScore(Score score);

    /**
     * 修改队伍状态量
     *
     * @param team 队伍id， 队伍状态量teamStatus
     * @return
     */
    int updateStatus(Team team);

    /**
     * 修改队伍评分状态
     * @param team
     * @return
     */
    int updateCanMark(Team team);

    /**
     * 获取所有队伍
     * @return
     */
    List<Team> getAllTeams();
}
