package com.springboot.workers.crudapi.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateTimeUtilities {
	
	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		return format.format(new Date(System.currentTimeMillis()));
	}
	
}
