package com.javatribe.scoreSystem.schedule;

import com.javatribe.scoreSystem.cache.ResultCache;
import com.javatribe.scoreSystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/15 16:16
 */

@Component
public class TimeTask {
    @Autowired
    ResultService resultService;

    /**
     * 定时任务：每6分钟刷新一次缓存数据
     */
    @Scheduled(cron = "00 1/6  * * * ?")
    public void updateResultSet() {
        ResultCache.resultCache = resultService.getResultSet();
    }
}
