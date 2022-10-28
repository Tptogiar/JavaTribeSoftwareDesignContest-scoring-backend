package com.javatribe.scoreSystem.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/24 19:48
 */

public class LoginCache {
    private static ConcurrentHashMap<String, Integer> loginCache = new ConcurrentHashMap<>();

    public static void add(String token, int id) {
        loginCache.put(token, id);
    }

    public static int getId(String token) {
        return loginCache.get(token);
    }

    public static int removeId(String token) {
        return loginCache.remove(token) > 0 ? 1 : 0;
    }

    public static boolean isLogined(String token) {
        if (loginCache.get(token) != null) {
            return true;
        } else {
            return false;
        }
    }
}
