package com.wzw.flower.utils;

import java.util.Random;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 11:37
 * @Version: 1.0
 */
public class CommonUtil {
    public static String getAccount(){
        String s = String.valueOf(new Random().nextInt(9)+1);
        while (s.length() < 12) {
            s += (int) (Math.random() * 10);
        }
        return s;
    }
}
