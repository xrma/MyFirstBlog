/**
 * 
 */
package com.sunray.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sunray
 *
 */
public class TimeUtil {
	public static final String FORMAT_14_WEB = "yyyy-MM-dd HH:mm:ss";
	
	public static String getCurrentTime(){
		SimpleDateFormat sf = new SimpleDateFormat(FORMAT_14_WEB);
		return sf.format(new Date());
	}
}
