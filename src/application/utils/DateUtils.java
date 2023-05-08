package application.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getCurrentTime() {

		SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
		String now = format.format(new Date());
		
		return now;
	}
}
