package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jeecms.utils.TimeUtil;
/**
 * 日期帮助类
 * @author daniel.fang
 *
 */
public class DateHelper {

	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param nationalHoliday	国定节假日（不含周末）
	 * @param weekend2WorkDay	周末调整为工作日
	 * @return
	 */
	public static int calWorkDayInterval(Date fromDate, Date toDate, String nationalHolidays, String weekend2WorkDays){
		GregorianCalendar fromCalendar = new GregorianCalendar();
		fromCalendar.setTime(fromDate);
		GregorianCalendar toCalendar = new GregorianCalendar();
		toCalendar.setTime(toDate);
		//直到from=to为止
		int workDayCount = 0;
		while(fromCalendar.compareTo(toCalendar) < 0){
			fromCalendar.add(Calendar.DAY_OF_WEEK, 1);//from增1
			GregorianCalendar temp = new GregorianCalendar();
			temp.set(fromCalendar.get(Calendar.YEAR), fromCalendar.get(Calendar.MONTH), fromCalendar.get(Calendar.DATE));
			boolean nhflag = containDate(temp.getTime(), "yyyyMMdd", nationalHolidays);
			if(nhflag){
				//国定假
				continue;
			}
			int tempDayOfWeek = temp.get(Calendar.DAY_OF_WEEK);
			if(tempDayOfWeek==1 || tempDayOfWeek==7){
				boolean w2wflag = containDate(temp.getTime(), "yyyyMMdd", weekend2WorkDays);
				if(w2wflag){
					workDayCount++;
				}
				continue;
			}
			workDayCount++;
		}
		return workDayCount;
	}
	
	
	/**
	 * 计算workDayInterval个工作日后的日期
	 * @param fromDate
	 * @param workDayInterval	工作日间隔
	 * @param nationalHolidays	国定节假日（不含周末）
	 * @param weekend2WorkDays	周末调整为工作日
	 * @return
	 */
	public static Date calAfterWorkDayDate(Date fromDate, int workDayInterval, String nationalHolidays, String weekend2WorkDays){
		GregorianCalendar toCalendar = new GregorianCalendar();
		toCalendar.setTime(fromDate);
		int i = 1;
		while(i <= workDayInterval){
			toCalendar.add(Calendar.DAY_OF_WEEK, 1);//下一天
			int dayOfWeek = toCalendar.get(Calendar.DAY_OF_WEEK);
			GregorianCalendar temp = new GregorianCalendar();
			temp.set(toCalendar.get(Calendar.YEAR), toCalendar.get(Calendar.MONTH), toCalendar.get(Calendar.DATE));
			if(dayOfWeek==1 || dayOfWeek==7){//周末
				boolean w2wFlag = containDate(temp.getTime(), "yyyyMMdd", weekend2WorkDays);
				if(w2wFlag){
					i++;
				}else{
					
				}
			}else{//非周末
				boolean nhFlag = containDate(temp.getTime(), "yyyyMMdd", nationalHolidays);
				if(nhFlag){
					
				}else{
					i++;
				}
			}
		}
		return toCalendar.getTime();
	}
	
	
	/**
	 * 日期包含
	 * @param d
	 * @param format
	 * @param days
	 * @return
	 */
	public static boolean containDate(Date d, String format, String days){
		if(d==null || StringUtils.isBlank(format) || StringUtils.isBlank(days)){
			return false;
		}
		String dateStr = new SimpleDateFormat(format).format(d);
		String[] dayArr = days.split(",");
		List<String> dayList = new ArrayList<String>(Arrays.asList(dayArr));
		if(dayList.contains(dateStr)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date fromDate = sdf.parse("20170819");
		//节假日
		String nationalHolidays = "20171002,20171003,20171004,20171005,20171006";
		String weekend2WorkDays = "20170930";
		/*System.out.println("2017-08-18|3："+calWorkDayInterval(fromDate, sdf.parse("20170818"), noWorkDays));
		System.out.println("2017-08-19|3："+calWorkDayInterval(fromDate, sdf.parse("20170819"), noWorkDays));
		System.out.println("2017-08-20|3："+calWorkDayInterval(fromDate, sdf.parse("20170820"), noWorkDays));
		System.out.println("2017-08-21|4："+calWorkDayInterval(fromDate, sdf.parse("20170821"), noWorkDays));
		System.out.println("2017-08-26|8："+calWorkDayInterval(fromDate, sdf.parse("20170826"), noWorkDays));
		System.out.println("2017-08-27|8："+calWorkDayInterval(fromDate, sdf.parse("20170827"), noWorkDays));
		System.out.println("2017-08-28|9："+calWorkDayInterval(fromDate, sdf.parse("20170828"), noWorkDays));*/
//		System.out.println("2017-08-16|1："+calWorkDayInterval(fromDate, sdf.parse("20170816"), nationalHolidays, weekend2WorkDays));
		
		int slaDay = calWorkDayInterval(fromDate, sdf.parse("20170825"), nationalHolidays, weekend2WorkDays);
		//计算非工作日，用总天数减去工作日
		long notWorkDay = TimeUtil.subtraction(sdf.parse("20170825"), fromDate) - slaDay;
		System.out.println("WorkDay: "+slaDay+", "+ "notWorkDay "+ notWorkDay);
		
		
		Date toDate = calAfterWorkDayDate(new Date(), 6, nationalHolidays, weekend2WorkDays);
		System.out.println(toDate);
	}
	
}
