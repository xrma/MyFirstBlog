/**
 * 
 */
package com.sunray.util;

/**
 * @Title: StringUtil.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 7, 2014 4:47:57 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null == str || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否不为空
     * 
     */
    public static boolean isNotEmpty(String str) {
        if (str != null && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
}
