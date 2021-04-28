package com.wzw.flower.utils;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * @author 传智.郭嘉
 *
 */
public class UUIDUtils {
	/**
	 * 获得随机的字符串
	 * @return
	 */
	public static String getUuId(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
