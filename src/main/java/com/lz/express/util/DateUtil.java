package com.lz.express.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 陈金虎 2017年1月16日 下午11:40:54
 * @类描述：日期相关工具类
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class DateUtil {

    /**
     * milliseconds in a second.
     */
    public static final long SECOND = 1000;

    /**
     * milliseconds in a minute.
     */
    public static final long MINUTE = SECOND * 60;

    /**
     * milliseconds in a hour.
     */
    public static final long HOUR = MINUTE * 60;

    /**
     * milliseconds in a day.
     */
    public static final long DAY = 24 * HOUR;

    /**
     * yyyy-MM
     */
    public static final String MONTH_PATTERN = "yyyy-MM";


    /**
     * yyyy-MM
     */
    public static final String MONTH_PATTERN_ = "yyyy_MM";

    /**
     * yyyyMM
     */
    public static final String MONTH_SHOT_PATTERN = "yyyyMM";


    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_PATTERN = "yyyyMMdd";


    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_DAY = "dd";


    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_PATTERN_WITH_HYPHEN = "yyyy-MM-dd";

    public static final String DEFAULT_PATTERN_WITH_DOT = "yyyy.MM.dd";

    public static final String DEFAULT_CHINESE_PATTERN = "yyyy年MM月dd日";
    public static final String DEFAULT_CHINESE_PATTERN_NOT_YEAH = "MM月dd日";

    public static final String DEFAULT_CHINESE_FULL_PATTERN = "yyyy年MM月dd日HH点mm分";

    public static final String HOUR_PATTERN = "yyyyMMddHH";


    /**
     * 格式 ：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATEFORMAT_STR_001 = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式 ：yyyy-MM-dd
     */
    public static final String DATEFORMAT_STR_002 = "yyyy-MM-dd";
    /**
     * 格式 ：MM-dd
     */
    public static final String DATEFORMAT_STR_003 = "MM-dd";
    /**
     * 格式 ：HH:mm:ss
     */
    public static final String DATEFORMAT_STR_004 = "HH:mm:ss";

    /**
     * 格式 ：yyyyMMddHHmmss
     */
    public static final String DATEFORMAT_STR_011 = "yyyyMMddHHmmss";
    /**
     * 格式 ：yyyyMMdd
     */
    public static final String DATEFORMAT_STR_012 = "yyyyMMdd";

    /**
     * 格式 ：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String DATEFORMAT_STR_021 = "yyyy年MM月dd日 HH时mm分ss秒";
    /**
     * 格式 ：yyyy年MM月dd日
     */
    public static final String DATEFORMAT_STR_022 = "yyyy年MM月dd日";
    /**
     * 格式 ：MM月dd日 hh:mm
     */
    public static final String DATEFORMAT_STR_23 = "MM月dd日 hh:mm";
    /**
     * 格式 ：yyyy年MM月dd日
     */
    public static final String DATEFORMAT_STR_024 = "MM月dd日";

    /**
     * 格式 ：yyyy-MM-dd
     */
    public static final String DATEFORMAT_STR_025 = "yyyy/MM/dd";
    /**
     * yyyyMMddHHmmss
     */
    public static final String FULL_PATTERN = "yyyyMMddHHmmss";

    /**
     * yyyyMMdd HH:mm:ss
     */
    public static final String FULL_STANDARD_PATTERN = "yyyyMMdd HH:mm:ss";

    /**
     * MM.dd HH:mm
     */
    public static final String FULL_MATCH_PATTERN = "MM.dd HH:mm";

    /**
     * HH:mm
     */
    public static final String SHORT_MATCH_PATTERN = "HH:mm";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_TIME_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * <pre>
     * yyyy-MM-dd HH:mm:ss
     * </pre>
     */
    public static final String DATE_TIME_SHORT = "yyyy-MM-dd HH:mm:ss";

    /**
     * <pre>
     * yyyy-MM-dd HH:mm:ss.SSS
     * </pre>
     */
    public static final String DATE_TIME_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_TIME_FULL_ALL = "yyyyMMddHHmmssSSS";

    public static final String NO_END_DATE_FORMAT = "9999-12-31 23:59:59";

    public static final Long NO_END_DATE_TIME = 253402271999000L;

    public static final Date NO_END_DATE = new Date(NO_END_DATE_TIME);
    public static final String FINAL_END_DATE_STR = "9999-12-31";

    /**
     * 一个月
     */
    public static final int DAY_OF_MONTH = 30;

    /**
     * 一星期
     */
    public static final int DAY_OF_WEEK = 7;

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * Add specified number of days to the given date.
     *
     * @param date date
     * @param days Int number of days to add
     * @return revised date
     */
    public static Date addDays(final Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Date(cal.getTime().getTime());
    }

    public static Date addMins(final Date date, int mins) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, mins);

        return new Date(cal.getTime().getTime());
    }


    public static Date getNoEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_SHORT);
        try {
            return sdf.parse(NO_END_DATE_FORMAT);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * Add specified number of hour to the date given.
     *
     * @param date Date
     * @param hour Int number of hour to add
     * @return Date
     */
    public static Date addHoures(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return cal.getTime();
    }

    public static Date addTime(Date date, int hour, int mins) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        cal.add(Calendar.MINUTE, mins);
        return cal.getTime();

    }

    /**
     * 返回一个Date默认最大值
     *
     * @return
     */
    public static Date getFinalDate() {
        return parseDate(FINAL_END_DATE_STR, DEFAULT_PATTERN_WITH_HYPHEN);
    }


    /**
     * 返回一个Date默认最大值
     *
     * @return
     */
    public static String getSimpleDateStr(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN_WITH_HYPHEN);
            return sdf.format(date);
        } catch (Exception e) {

        }
        return null;
    }


    /**
     * 返回一个Date默认最大值
     *
     * @return
     */
    public static String getSimpleDateDayStr(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DAY);
            return sdf.format(date);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * Add specified number of months to the date given.
     *
     * @param date   Date
     * @param months Int number of months to add
     * @return Date
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * Get date one day after specified one.
     *
     * @param date1 Date 1
     * @param date2 Date 2
     * @return true if date1 after date2
     */
    public static boolean afterDay(final Date date1, final Date date2) {
        return date1.after(date2);
//        return getStartOfDate(date1).after(getStartOfDate(date2));
    }

    /**
     * judge the srcDate is between startDate and endDate
     *
     * @param srcDate
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isBetweenDateRange(final Date srcDate, final Date startDate, final Date endDate) {
        if (srcDate != null && startDate != null && endDate != null) {
            return srcDate.getTime() >= startDate.getTime() && srcDate.getTime() <= endDate.getTime();
        }
        return false;
    }


    /**
     * Get date one day before specified one.
     *
     * @param date1 test date
     * @param date2 date when
     * @return true if date1 is before date2
     */
    public static boolean beforeDay(final Date date1, final Date date2) {
        return getStartOfDate(date1).before(getStartOfDate(date2));
    }

    /**
     * long类型的milliseconds转换成Date类型的时间
     *
     * @param time
     * @return
     */
    public static Date convert(long time, Date defaultDate) {
        try {
            Date date = new Date(time);
            return date;
        } catch (Exception e) {
            return defaultDate;
        }
    }

    /**
     * 转换long类型到时,分,秒,毫秒的格式.
     *
     * @param time long type
     * @return
     */
    public static String convert(long time) {
        long ms = time % 1000;
        time /= 1000;

        int h = Integer.valueOf("" + (time / 3600));
        int m = Integer.valueOf("" + ((time - h * 3600) / 60));
        int s = Integer.valueOf("" + (time - h * 3600 - m * 60));

        return h + "小时(H)" + m + "分(M)" + s + "秒(S)" + ms + "毫秒(MS)";
    }

    /**
     * 转换long类型到时,分,秒,毫秒的格式.
     *
     * @param time long type
     * @return
     */
    public static String convertEn(long time) {
        long ms = time % 1000;
        time /= 1000;

        int h = Integer.valueOf("" + (time / 3600));
        int m = Integer.valueOf("" + ((time - h * 3600) / 60));
        int s = Integer.valueOf("" + (time - h * 3600 - m * 60));

        return h + "H" + m + "M" + s + "S" + ms + "MS";
    }

    /**
     * @param aDate
     * @return
     */
    public static String convertDateToString(String pattern, Date aDate) {
        return getDateTime(pattern, aDate);
    }

    /**
     * 毫秒转换成时间
     *
     * @param millis
     * @return
     */
    public static Date convertMillisToDate(long millis, Date defaultDate) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(millis);
            return calendar.getTime();
        } catch (Exception e) {
            return defaultDate;
        }
    }

    /**
     * This method generates a string representation of a date/time in the format you specify on input
     *
     * @param aMask   the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @throws ParseException when String doesn't match the expected format
     * @see SimpleDateFormat
     */
    public static Date convertStringToDate(String aMask, String strDate) {
        SimpleDateFormat df;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (logger.isDebugEnabled()) {
            logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.error("ParseException: " + pe);
        }

        return date;
    }

    /**
     * @return the current date without time component
     * 不带时分秒
     */
    public static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 判断当前时间距离第二天凌晨的秒数
     *
     * @return 返回值单位为[s:秒]
     */
    public static Integer getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        String timestamp = String.valueOf((cal.getTimeInMillis() - System.currentTimeMillis()) / 1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * @return get system current date
     * 当前时分秒
     */
    public static Date getCurrentDate() {
        Long time = System.currentTimeMillis();
        return new Date(time);
    }


    /**
     * 获取dayOff天之前（后）的当前时间
     * <p>
     * if < 0 , return dayOff天前的时间
     * <p>
     * if > 0 , return dayOff后的时间
     *
     * @return
     */
    public static String getCertainDayStr(int dayOff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayOff);
        return formatDate(calendar.getTime(), DEFAULT_PATTERN);
    }

    /**
     * 格式化日期，返回yyyy-mm-dd
     *
     * @param date
     * @return
     */
    public static String formatShortDate(Date date) {

        return formatDate(date, DEFAULT_PATTERN_WITH_HYPHEN);
    }

    /**
     * 获取dayOff天之前（后）的当前时间
     * <p>
     * if < 0 , return dayOff天前的时间
     * <p>
     * if > 0 , return dayOff后的时间
     *
     * @return
     */
    public static Date getCertainDay(int dayOff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayOff);
        return calendar.getTime();
    }

    public static String getCertainHour(int hourOff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, hourOff);
        return formatDate(calendar.getTime(), HOUR_PATTERN);
    }

    /**
     * Format date as "yyyyMMdd".
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String formatDate(final Date date) {
        return formatDate(date, DEFAULT_PATTERN);
    }

    /**
     * Format date as given date format.
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String formatDate(final Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Format date as given date format.
     *
     * @param timeStamp 毫秒级别时间戳
     * @return 格式化后的日期字符串
     */
    public static String formatDate(long timeStamp, String format) {
        Date date = new Date(timeStamp);
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, DATE_TIME_SHORT);
    }


    public static Date getAccuracyTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * <p><code>getAccuracyTimeWithAmount(Calendar.DAY_OF_MONTH, -5)</code>.
     *
     * @param field  the calendar field.
     * @param amount the amount of date or time to be added to the field.
     * @return
     */
    public static Date getAccuracyTimeWithAmount(int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * Format date as "MM月dd日 HH:mm".
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String formatFullMatchDate(final Date date) {
        return formatDate(date, FULL_MATCH_PATTERN);
    }

    /**
     * 返回MM月dd日
     *
     * @param srcDate
     * @return
     */
    public static String formatMonthAndDay(Date srcDate) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(srcDate);
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");

        return formatter.format(srcDate);
    }

    /**
     * 返回短日期格式
     *
     * @return [yyyy-mm-dd]
     */
    public static String formatShort(String strDate) {
        String ret = "";
        if (strDate != null && !"1900-01-01 00:00:00.0".equals(strDate) && strDate.indexOf("-") > 0) {
            ret = strDate;
            if (ret.indexOf(" ") > -1) {
                ret = ret.substring(0, ret.indexOf(" "));
            }
        }
        return ret;
    }

    /**
     * 格式化中文日期短日期格式
     *
     * @param gstrDate 输入欲格式化的日期
     * @return [yyyy年MM月dd日]
     */

    public static String formatShortDateC(Date gstrDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String pid = formatter.format(gstrDate);
        return pid;
    }

    /**
     * Format date as "HH:mm".
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String formatShortMatchDate(final Date date) {
        return formatDate(date, SHORT_MATCH_PATTERN);
    }

    public static Date getCurrentMonday() {
        Calendar cd = Calendar.getInstance();

        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        Date date;
        if (dayOfWeek == 1) {
            date = cd.getTime();
        } else {
            date = addDays(cd.getTime(), 1 - dayOfWeek);
        }

        return getStartOfDate(date);
    }

    /**
     * Return default datePattern (yyyy-MM-dd)
     *
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        return "yyyy-MM-dd";
    }

    public static String getDateTime(Date date) {
        return formatDate(date, DATE_TIME_SHORT);
    }

    public static Long getTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String getTimeStr(Date date) {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * This method generates a string representation of a date's date/time in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * @see SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            logger.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    public static String getDateTimeFull(Date date) {
        return formatDate(date, DATE_TIME_FULL);
    }

    public static String getDateTimeFullAll(Date date) {
        if (date == null) {
            return "";
        }
        try {
            return formatDate(date, DATE_TIME_FULL_ALL);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * 返回当前日
     *
     * @return [dd]
     */

    public static String getDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date nowc = new Date();
        String pid = formatter.format(nowc);
        return pid;
    }

    public static int getNowHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(formatter.format(new Date()));
        return hour;
    }

    public static boolean checkHour(String value) {
        int hour = getNowHour();
        String[] str = value.split("-");
        return hour > Integer.parseInt(str[0]) && hour < Integer.parseInt(str[1]);
    }

    public static boolean checkLimit(String value) {
        //int hour = getNowHour();
        String[] str = value.split("-");
        // return hour>Integer.parseInt(str[0].replace(":00","")) && hour<Integer.parseInt(str[1].replace(":00",""));
        String[] time1 = str[0].split(":");
        String[] time2 = str[1].split(":");
        return System.currentTimeMillis() > DateUtil.addTime(DateUtil.getStartOfDate(new Date()), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])).getTime() && System.currentTimeMillis() < DateUtil.addTime(DateUtil.getStartOfDate(new Date()), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])).getTime();
    }

    public static int getNowMinute() {
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        int minute = Integer.parseInt(formatter.format(new Date()));
        return minute;
    }

    //是否是月的最后一天
    public static boolean isLastDayOfMonth(Date date) {
        return isSameDay(date, getEndOfMonth(date));
    }

    /**
     * 一天的结束时间，【注：只精确到毫秒】
     *
     * @param date
     * @return
     */
    public static Date getEndOfDate(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 一天的结束时间，【注：只精确到毫秒】
     *
     * @param date
     * @return
     */
    public static Date getEndOfDateSECOND(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 一天的结束时间，【注：只精确到秒】
     *
     * @param date
     * @return
     */
    public static Date getEndOfDatePrecisionSecond(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 000);

        return new Date(cal.getTime().getTime());
    }

    /**
     * Return the end of the month based on the date passed as input parameter.
     *
     * @param date Date
     * @return Date endOfMonth
     */
    public static Date getEndOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DATE, 0);

        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * Get first day of month.
     *
     * @param date Date
     * @return Date
     */
    public static Date getFirstOfMonth(final Date date) {
        Date lastMonth = addMonths(date, -1);
        lastMonth = getEndOfMonth(lastMonth);
        return addDays(lastMonth, 1);
    }

    public static Date getMondayBefore4Week() {
        Calendar cd = Calendar.getInstance();

        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        Date date;
        if (dayOfWeek == 1) {
            date = addDays(cd.getTime(), -28);
        } else {
            date = addDays(cd.getTime(), -27 - dayOfWeek);
        }

        return getStartOfDate(date);
    }


    /**
     * 返回当前日
     *
     * @return [dd]
     */

    public static String getDay(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回当前月份,如果date为null则返回当前月份
     *
     * @return [MM]
     */

    public static String getMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回当前年份,如果date为null则返回当前年份
     *
     * @return [MM]
     */

    public static String getYear(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回标准格式的当前时间
     *
     * @return [yyyy-MM-dd k:mm:ss]
     */

    public static Date getNow() {
        return new Date();
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static Date formatDateToYYYYMMdd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(sdf.format(date));
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatDateToYYYYMMddStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDateToYYYYMMddHHmmss(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * get date time as "yyyyMMddhhmmss"
     *
     * @return the current date with time component
     */
    public static String getNowYearMonthDay() {
        return formatDate(new Date(), DEFAULT_PATTERN);
    }


    /**
     * get date time as "yyyyMMdd"
     *
     * @return the current date with time component
     */
    public static String getNowYearMonthDay(Date date) {
        return formatDate(date, DEFAULT_PATTERN);
    }

    /**
     * @param timeString 年、月、日   eg。“MM”,"YYYY"
     * @param timeLong   时间搓
     * @return
     */
    public static int getTimeYearOrMonthOrDay(String timeString, long timeLong) {
        SimpleDateFormat formatter = new SimpleDateFormat(timeString);
        Date nowc = new Date(timeLong);

        int time = NumberUtil.objToIntDefault(formatter.format(nowc), -1);

        return time;
    }


    /**
     * 计算2个日前直接相差的天数
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static long getNumberOfDaysBetween(Calendar cal1, Calendar cal2) {
        cal1.clear(Calendar.MILLISECOND);
        cal1.clear(Calendar.SECOND);
        cal1.clear(Calendar.MINUTE);
        cal1.clear(Calendar.HOUR_OF_DAY);

        cal2.clear(Calendar.MILLISECOND);
        cal2.clear(Calendar.SECOND);
        cal2.clear(Calendar.MINUTE);
        cal2.clear(Calendar.HOUR_OF_DAY);

        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return elapsed / DAY;
    }

    /**
     * 为避免扩大影响范围，该方法只在百凌使用
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static long getNumberOfDaysBetween4BL(Calendar cal1, Calendar cal2) {
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return elapsed / DAY;
    }

    /**
     * 计算两日期之间相差的天数
     *
     * @param before
     * @param end
     * @return
     */
    public static long getNumberOfDatesBetween(Date before, Date end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(before);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        return getNumberOfDaysBetween(cal1, cal2);
    }

    /**
     * 返回两个时间间隔的小时数
     *
     * @param before 起始时间
     * @param end    终止时间
     * @return 小时数
     */
    public static long getNumberOfHoursBetween(final Date before, final Date end) {
        long millisec = end.getTime() - before.getTime() + 1;
        return millisec / (60 * 60 * 1000);
    }

    /**
     * 返回两个时间间隔的分钟数
     *
     * @param before 起始时间
     * @param end    终止时间
     * @return 分钟数
     */
    public static long getNumberOfMinuteBetween(final Date before, final Date end) {
        long millisec = end.getTime() - before.getTime();
        return millisec / (60 * 1000);
    }

    public static int getNumberOfMonthsBetween(final Date before, final Date end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(before);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        return (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12
                + (cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH));
    }

    public static int getNumberOfSecondsBetween(final double end, final double start) {
        if ((end == 0) || (start == 0)) {
            return -1;
        }

        return (int) (Math.abs(end - start) / SECOND);
    }

    public static Date getPreviousMonday() {
        Calendar cd = Calendar.getInstance();

        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        Date date;
        if (dayOfWeek == 1) {
            date = addDays(cd.getTime(), -7);
        } else {
            date = addDays(cd.getTime(), -6 - dayOfWeek);
        }

        return getStartOfDate(date);
    }

    /**
     * 返回中文格式的当前日期
     *
     * @return [yyyy-mm-dd]
     */
    public static String getShortNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date nowc = new Date();
        String pid = formatter.format(nowc);
        return pid;
    }

    /**
     * 返回中文格式的当前月份
     *
     * @return [yyyy-mm]
     */
    public static String getShortMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        Date nowc = new Date();
        String pid = formatter.format(nowc);
        return pid;
    }

    /**
     * Get start of date.
     *
     * @param date Date
     * @return Date Date
     */
    public static Date getStartOfDate(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 返回当前时间24小时制式
     *
     * @return [H:mm]
     */

    public static String getTimeBykm() {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm");
        Date nowc = new Date();
        String pid = formatter.format(nowc);
        return pid;
    }

    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getTodayLast() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 检查日期的合法性
     *
     * @param sourceDate
     * @return
     */
    public static boolean inFormat(String sourceDate, String format) {
        if (sourceDate == null) {
            return false;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(sourceDate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = GregorianCalendar.getInstance();
        cal2.setTime(date2);

        return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
                && (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) && (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)));
    }

    /**
     * Compare the two calendars whether they are in the same month.
     *
     * @param cal1 the first calendar
     * @param cal2 the second calendar
     * @return whether are in the same month
     */
    public static boolean isSameMonth(Calendar cal1, Calendar cal2) {
        return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
                && (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH));
    }

    /**
     * Compare the two dates whether are in the same month.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return whether are in the same month
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = GregorianCalendar.getInstance();
        cal2.setTime(date2);
        return isSameMonth(cal1, cal2);
    }

    /**
     * get date time as "yyyyMMddhhmmss"
     *
     * @return the current date with time component
     */
    public static String now() {
        return formatDate(new Date(), FULL_PATTERN);
    }

    /**
     * change the string to date
     *
     * @param date
     * @return Date if failed return <code>null</code>
     */
    public static Date parseDate(String date) {
        return parseDate(date, DEFAULT_PATTERN, null);
    }


    public static Date parseDate1(String date) {
        Date d = null;
        d = parseDate(date, DATEFORMAT_STR_001, null);
        if (d == null) {
            d = parseDate(date, DATEFORMAT_STR_002, null);
        }
        return d;
    }


    public static Date parseDate2(String date) {
        return parseDate(date, DATE_TIME_SHORT, null);
    }

    public static Date parseDateV1(String date) {
        return parseDate(date, DEFAULT_PATTERN_WITH_HYPHEN, null);
    }

    /**
     * change the string to date
     *
     * @param date
     * @param df
     * @return Date
     */
    public static Date parseDate(String date, String df) {
        return parseDate(date, df, null);
    }

    /**
     * 日期转换为字符串 格式自定义
     *
     * @param date
     * @param f
     * @return
     */
    public static String dateStr(Date date, String f) {
        SimpleDateFormat format = new SimpleDateFormat(f);
        if (date != null) {
            String str = format.format(date);
            return str;
        }
        return "";
    }

    /**
     * yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String dateStr6(Date date) {
        return dateStr(date, DEFAULT_CHINESE_PATTERN);
    }

    /**
     * change the string to date
     *
     * @param date
     * @param df           DateFormat
     * @param defaultValue if parse failed return the default value
     * @return Date
     */
    public static Date parseDate(String date, String df, Date defaultValue) {
        if (StringUtils.isBlank(date)) {
            return defaultValue;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(df);

        try {
            return formatter.parse(date);
        } catch (ParseException e) {
        }

        return defaultValue;
    }

    private DateUtil() {

    }

    /**
     * parse object to date
     *
     * @param obj
     * @return
     */
    public static Date parseObjToDate(Object obj) {
        Date date = null;
        try {
            date = (Date) obj;
        } catch (Exception e) {
            date = Calendar.getInstance().getTime();
        }
        return date;
    }

    /**
     * 返回yyyyMMdd HH:mm:ss格式日期
     *
     * @return
     */
    public static Date parseDateyyyyMMddHHmmss(String dateStr) {
        if (dateStr == null || dateStr.length() == 0) {
            return null;
        }
        SimpleDateFormat parser = new SimpleDateFormat(FULL_STANDARD_PATTERN);
        try {
            return parser.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @Title: compareDate
     * @Description: (日期比较 ， 如果s > = e 返回true 否则返回false)
     */
    public static boolean compareDate(Date s, Date e) {
        return s.getTime() >= e.getTime();
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @Title: compareDate
     * @Description: (日期比较 ， 如果s > = e 返回true 否则返回false)
     */
    public static boolean compareDateV1(Date s, Date e) {
        return s.getTime() > e.getTime();
    }


    public static Date stringToDate(String date) throws ParseException {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        SimpleDateFormat fromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fromat.parse(date);
    }

    public static Date stringTranDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        Date resultDate = new Date();
        SimpleDateFormat fromat = new SimpleDateFormat(DateUtil.DEFAULT_PATTERN_WITH_HYPHEN);
        try {
            resultDate = fromat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    public static Integer getCurrentYear() {
        Calendar calender = Calendar.getInstance();
        return calender.get(Calendar.YEAR);
    }


    public static Integer getCurrentYear(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        return calender.get(Calendar.YEAR);
    }

    public static Integer getCurrentMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        return calender.get(Calendar.MONTH) + 1;
    }

    public static Integer getCurrentDay(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        return calender.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer getCurrentDay() {
        Calendar calender = Calendar.getInstance();
        return calender.get(Calendar.DAY_OF_MONTH);
    }


    public static Integer getCurrentSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }


    public static Integer getCurrentMonth() {
        Calendar calender = Calendar.getInstance();
        return calender.get(Calendar.MONTH) + 1;
    }

    /**
     * 一天的结束时间，【注：只精确到毫秒】
     *
     * @param date
     * @return
     */
    public static Date getWithDrawOfDate(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 000);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss格式日期
     *
     * @return
     */
    public static Date parseDateTimeShortExpDefault(String dateStr, Date defaultDate) {
        if (dateStr == null || dateStr.length() == 0) {
            return defaultDate;
        }
        SimpleDateFormat parser = new SimpleDateFormat(DATE_TIME_SHORT);
        try {
            return parser.parse(dateStr);
        } catch (ParseException e) {
            return defaultDate;
        }
    }

    public static long getSecsEndOfDay() {
        Date nowDate = new Date();
        Date endDate = getEndOfDate(nowDate);
        long secs = (endDate.getTime() - nowDate.getTime()) / 1000;
        return secs;
    }

    public static Date getBeforeDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }


    public static Date getBeforeMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -minute);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }

    public static Date getAfterMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }


    /**
     * judge the srcDate is between startDate and endDate
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long betweenSecond(Date startDate, Date endDate) {
        Long a = endDate.getTime() - startDate.getTime();
        return a / 1000;
    }

    public static final Integer[] MONTH_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public static Date addMonths(String strDate, int months) throws ParseException {
        Date date = DateUtil.stringToDate(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

//    public static void main(String[] args) throws  Exception {

//        Date date1 = addMonths(currentDate(),1);
//        System.out.println(date1);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date1);
//        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        calendar.set(Calendar.DATE, 31);
//        System.out.println(new Date(calendar.getTimeInMillis()));
//        Date date = DateUtil.addMonths(date1,6);
//        System.out.println(date);
//        int year = DateUtil.getCurrentYear();
//        int mouth = DateUtil.getCurrentMonth();
//        System.out.println(mouth);
//        System.out.println(DateUtil.getCurrentDay());
//        Integer mouthDay = MONTH_DAY[mouth+1];
//        System.out.println(mouthDay);
//
//        //本月还款日+1，即为下个月还款日
//        Date thisMonthRepayDay = DateUtil.getThisMonthRepayDay(31);
//        System.out.println(thisMonthRepayDay);
//        System.out.println(DateUtil.formatDateToYYYYMMddHHmmss(thisMonthRepayDay));
//        Date nextMonthRepayDay = DateUtil.addMonths(thisMonthRepayDay,1);
//        System.out.println(nextMonthRepayDay);
//        System.out.println(DateUtil.formatDateToYYYYMMddHHmmss(nextMonthRepayDay));
//        System.out.println(DateUtil.daysBetween(new Date(), nextMonthRepayDay));
//        System.out.println(DateUtil.afterDay(new Date(),nextMonthRepayDay));
//        Date first = DateUtil.parseDate("2018-06-23 12:12:12",DateUtil.DATE_TIME_SHORT);
//        Calendar fc = Calendar.getInstance();
//        fc.setTime(first);
//        Calendar now = Calendar.getInstance();
//        //todo 时间差有问题
//
//        Calendar lastCalendar = fc;
//        lastCalendar.add(Calendar.MONTH,2);
//        //lastCalendar.add(Calendar.MONTH,3);
//        Long Intervals = DateUtil.getNumberOfDaysBetween(now,lastCalendar);
//        int days = Intervals.intValue();
//        System.out.println(days);
//        System.out.print(DateUtil.getDay());

//    }

    public static Date getMonthRepayDay(Date date, int repayDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DATE, repayDay > lastDay ? lastDay : repayDay);
        return new Date(calendar.getTimeInMillis());
    }


    /**
     * @Author：zgh
     * @Description：判断是否在某个时间内
     * @Date：15:40 2018/2/11
     */
    public static boolean checkDiscountTime(Date gmtStart, Date gmtEnd) {
        return System.currentTimeMillis() >= gmtStart.getTime() && System.currentTimeMillis() <= gmtEnd.getTime();
    }

    /**
     * @Author：zgh
     * @Description：判断两个时间相差
     * @Date：10:20 2018/2/12
     */
    public static long calculateTime(Date endTime) {
        long millisec = endTime.getTime() - System.currentTimeMillis();
        if (millisec > 0) {
            return millisec;
        }
        return 0L;
    }

    /**
     * 返回两个时间相差秒数
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return
     */
    public static long calculateTime(Date time1, Date time2) {
        long millisec;
        if (time1.compareTo(time2) >= 0) {
            millisec = (time1.getTime() - time2.getTime()) / 1000;
        } else {
            millisec = (time2.getTime() - time1.getTime()) / 1000;
        }
        return millisec;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr7(date1));
            Date d2 = sdf.parse(DateUtil.dateStr7(date2));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf((time2 - time1) / 86400000L));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String dateStr7(Date date) {
        return dateStr(date, DEFAULT_PATTERN);
    }

    /**
     * 过去的一天距今多少年 不满一年算一年
     *
     * @param sourceDate
     * @param currentDate
     * @return
     */
    public static int yearsBetween(Date sourceDate, Date currentDate) {
        int days = daysBetween(sourceDate, currentDate);
        double years = (days * 1.0) / 365.0;
        int ceil = (int) Math.ceil(years);
        return ceil;
    }

    /**
     * 获取今天拼接给定时分秒
     *
     * @param date
     * @return
     */
    public static Date parseDateTodayYMD(String date, Date currentDate) {
        String yearMonthDayStr = DateUtil.formatDate(currentDate, DateUtil.DEFAULT_PATTERN_WITH_HYPHEN);
        date = yearMonthDayStr.concat(" ").concat(date);

        Date resultDate = DateUtil.parseDate(date, DateUtil.DATE_TIME_MINUTE);

        return resultDate;
    }


    private static boolean sameDate(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat(DateUtil.DEFAULT_PATTERN);
        //fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置
        return fmt.format(d1).equals(fmt.format(d2));
    }

    public static int checkTimeV1(Date time1, Date time2) {
        if (getStartOfDate(time1).getTime() < getStartOfDate(time2).getTime()) {
            return 1;
        } else if (getStartOfDate(time1).getTime() == getStartOfDate(time2).getTime()) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int yearBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        return end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
    }

    public static boolean isSameMonthDay(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        return end.get(Calendar.MONTH) - start.get(Calendar.MONTH) == 0 && end.get(Calendar.DAY_OF_MONTH) - start.get(Calendar.DAY_OF_MONTH) == 0;
    }

    public static boolean isRunYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static String formatDateStr(String dateStr) {
        if (StringUtil.isBlank(dateStr)) {
            return "";
        }
        return formatShortDate(parseDate(dateStr));
    }


    public static String formatSimpleDateStr(String dateStr) {
        if (StringUtil.isBlank(dateStr)) {
            return "";
        }


        Date date = parseDate1(dateStr);
        return formatShortDate(date);
    }


    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getStandeSimpleDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FULL);

        return simpleDateFormat.format(new Date());
    }

    public static boolean isPreDay(Date gmtCreate) {
        if (gmtCreate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN_WITH_HYPHEN);
        Date preDate = DateUtil.addDays(new Date(), -1);
        if (sdf.format(preDate).equals(sdf.format(gmtCreate))) {
            return true;
        }
        return false;
    }


    public static boolean isCurrDay(Date gmtCreate) {
        if (gmtCreate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN_WITH_HYPHEN);
        Date preDate = new Date();
        if (sdf.format(preDate).equals(sdf.format(gmtCreate))) {
            return true;
        }
        return false;
    }

    /**
     * 下一年年底23 59 59 秒过期
     *
     * @param date
     * @return
     */
    public static Date getNextYearLast(Date date) {
        try {
            Calendar currCal = Calendar.getInstance();
            currCal.setTime(DateUtil.addMonths(date, 12));
            int currentYear = currCal.get(Calendar.YEAR);
            Date d = getYearLast(currentYear);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String b = df.format(d);
            b = b + " 23:59:59";
            SimpleDateFormat dfNew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dfNew.parse(b);
        } catch (ParseException e) {
            logger.error("解析失败", e);
        }
        return new Date();
    }

    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }


    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};


    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDateObject(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }


    public static Date getDate(String times) {
        long time = Long.parseLong(times);
        return new Date(time * 1000);
    }

    public static String dateStr(String times) {
        return dateStr(getDate(times));
    }

    /**
     * 日期转换为字符串 MM月dd日 hh:mm
     *
     * @param date
     * @return
     */
    public static String dateStr(Date date) {
        return dateStr(date, DATEFORMAT_STR_023);
    }

    /**
     * 格式 ：MM月dd日 hh:mm
     */
    public static final String DATEFORMAT_STR_023 = "MM月dd日 hh:mm";


    public static String dateStr3(String times) {
        return dateStr3(getDate(times));
    }


    /**
     * yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String dateStr3(Date date) {
        return dateStr(date, DATEFORMAT_STR_011);
    }


    public static String dateStr4(String times) {
        return dateStr4(getDate(times));
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String dateStr4(Date date) {
        return dateStr(date, DATEFORMAT_STR_001);

    }

    public static Date getPreMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(getPrevMonthDate(getStartOfDate(date), 1));
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return c.getTime();
    }

    public static Date getPreMonthLastDay(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(getPrevMonthDate(getEndOfDate(date), 1));
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    public static Date getPrevMonthDate(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n);
        return calendar.getTime();
    }


    public static void main(String[] args) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date d = df.parse("2021-10-11 12:00:00");
            System.out.println(df.format(getPreMonthFirstDay(d)));
            System.out.println(df.format(getPreMonthLastDay(d)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
