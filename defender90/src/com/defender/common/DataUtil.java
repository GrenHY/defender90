package com.defender.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.istack.internal.Nullable;

public class DataUtil {
	
	/**
	 * 每月任务文件名格式：events_2017-03-01[_wu]
	 * @param pre
	 * @return
	 */
	public static String obtainDayTaskName(@Nullable String prefix, @Nullable String suffix) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String date = format.format(new Date());
		
		return prefix+"_"+date+("".equals(suffix)? "" : "_"+suffix);
	}
	
}
