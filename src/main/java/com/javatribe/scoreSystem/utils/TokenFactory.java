package com.javatribe.scoreSystem.utils;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/17 12:10
 */

public final class TokenFactory {
    public static String token(String name, String password) {
        String union = name.hashCode() + password.hashCode() + "ScoreSystem" + System.currentTimeMillis();
        char[] chars = union.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            chars[l] ^= 2;
            chars[r] |= 5;
            l++;
            r--;
        }
        String token = String.valueOf(chars);
        return String.format("{\"token\": \"%s\"}",token);
    }


    public static void main1(String[] args) {
        String token = token("水电费", "pwbl");
        System.out.println(token);
    }
}
