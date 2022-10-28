package com.javatribe.scoreSystem.cache;

import com.javatribe.scoreSystem.entity.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/15 16:11
 */

public final class ResultCache {
    public static volatile List<Result> resultCache = new ArrayList<>();
}
