package com.q10viking.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.DayOfWeek;
public class GetDateTimeUtil {

	public static String getDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日",Locale.US);
		DayOfWeek day = now.getDayOfWeek();
		String dayStr = day.getDisplayName(TextStyle.FULL, Locale.CHINA);
		String str = now.format(format);
		return str+"  "+dayStr;
	}
	
	public static String getTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("kk:mm:ss",Locale.CHINA);
		String time = now.format(format);
		return time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getDateTime());
		System.out.println(getTime());
	}

}
