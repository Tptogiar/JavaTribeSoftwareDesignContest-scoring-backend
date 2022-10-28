package com.javatribe.scoreSystem.utils;

import com.alibaba.fastjson.JSONArray;

/**
 * 工具类，将实体对象转换为JSON字符串
 *
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/16 22:13
 */

public class JSONUtil {
    public static String toJSON(Object object) {
        return JSONArray.toJSONString(object);
    }
}
