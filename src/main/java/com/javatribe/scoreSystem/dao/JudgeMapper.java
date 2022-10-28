package com.javatribe.scoreSystem.dao;

import com.javatribe.scoreSystem.entity.Result;
import com.javatribe.scoreSystem.entity.Score;
import com.javatribe.scoreSystem.entity.Team;

import java.util.List;
import java.util.Map;

public interface JudgeMapper {
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
     * 判断评委对某一个队伍是否已评分
     * @param score
     * @return
     */
    int isMarked(Score score);

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
     * @param score 新的分数，队伍id， 评委id
     * @return
     */
    int updateScore(Score score);

    /**
     * 修改队伍状态
     *
     * @param team 队伍状态量，0为上场，1为下场
     * @return
     */
    int updateStatus(Team team);

    /**
     * 修改队伍评分状态
     *
     * @param team 评分状态量，0为可评，1为禁评
     * @return
     */
    int updateCanMark(Team team);
    /**
     * 获取所有队伍
     * @return
     */
    List<Team> selectAllTeams();

    /**
     * 获取评分可否状态
     * @param id
     * @return
     */
    Long selectCanMark(Long id);
}
