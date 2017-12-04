package net.eoutech.vifi.as.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2015/8/5.
 */
public class DateUtils {
	/**
	 * parse String format "yyyy-MM-dd HH:mm:ss" to Date
	 */
	public static Date parseDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * format Date to String, "yyyy-MM-dd HH:mm:ss"
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	/**
	 * format current Date "yyyy-MM-dd HH:mm:ss"
	 */
	public static String formatDate() {
		return formatDate(new Date());
	}

	public static boolean isTimeout(int expire, int delay, long lastUpdateTime) {
		return (System.currentTimeMillis() - lastUpdateTime) > (expire + delay) * 1000 ? true : false;
	}

	/**
	 * 判断是否为同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		
		if ( date1 == null || date2 == null ) {
			return false;
		}
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}

	/**
	 * 判断是否为同一月
	 * @param date1
	 * @param date2
     * @return
     */
	public static boolean isSameMonth ( Date date1, Date date2 ) {
		if ( date1 == null || date2 == null ) {
			return false;
		}

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		return isSameMonth;
	}

}
