package com.wzw.flower.utils;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 9:30
 * @Version: 1.0
 */
public class HumpToUnderlineUtil {
    public static String humpToUnderline(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            for (int i = 0; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(HumpToUnderlineUtil.humpToUnderline("typeCategoryId"));
    }
}
