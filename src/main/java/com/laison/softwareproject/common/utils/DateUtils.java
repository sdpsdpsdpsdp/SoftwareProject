package com.laison.softwareproject.common.utils;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Log4j2
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd'T'HH:mm:ss+01:00", "yyyy-MM-dd'T'HH:mm:ss+08:00", "yyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMddHHmmss", "yyyyMMdd", "yyyyMM", "yyyy"};

    /**
     * 用这个方法将字符串转成Date
     */
    public static Date parseDate(String dateStr) throws ParseException {
        return parseDate(dateStr, parsePatterns);
    }

    public static Date parseDingDingDate(String dateStr) throws ParseException {
        // return  parseDate(dateStr,"yyyy-MM-dd'T'HH:mm:ss+08:00","yyy-MM-dd'T'HH:mm:ss'Z'");
        return parseDate(dateStr, parsePatterns);
    }

    /**
     * 将时间转换成 默认格式 "yyyy-MM-dd HH:mm:ss"
     *
     * @return
     */
    public static String formatDate(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将时间转换成用户定义的格式
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {

        return DateFormatUtils.format(date, pattern);
    }

    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    public static Date defaultTime() {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        return instance.getTime();
    }

    /**
     * @param date 日期
     * @return 年的部分 2019年的话 返回19
     */
    public static byte[] getTimeByteArray(Date date) {
        byte[] array = {};
        Integer year = DateUtil.year(date);
        year -= 2000;
        array = ArrayUtils.add(array, year.byteValue());// 添加1位年
        Integer month = DateUtil.month(date) + 1;
        array = ArrayUtils.add(array, month.byteValue());// 添加1位月
        Integer day = DateUtil.dayOfMonth(date);
        array = ArrayUtils.add(array, day.byteValue());// 添加1位日
        Integer hour = DateUtil.hour(date, true);
        array = ArrayUtils.add(array, hour.byteValue());// 添加1位时
        Integer minute = DateUtil.minute(date);
        array = ArrayUtils.add(array, minute.byteValue());// 添加1位分
        Integer second = DateUtil.second(date);
        array = ArrayUtils.add(array, second.byteValue());// 添加1位秒
        Integer dayOfWeek = DateUtil.dayOfWeek(date);
        array = ArrayUtils.add(array, dayOfWeek.byteValue());// 添加1位秒
        return array;
    }

    public static Date byteArrayToTime(byte[] date) {
        if (!(date.length == 7))
            return defaultTime();
        Calendar instance = Calendar.getInstance();

        instance.set(2000 + date[0], date[1] - 1, date[2], date[3], date[4], date[5]);
        return instance.getTime();
    }

    public static Date date() {
        return new Date();
    }

//    /**
//     * 获取当前登录用户的时间，如果没有当前登录的用户则使用系统时间<br>
//     * 最好使用 deptUtcDate
//     *
//     * @return
//     */
//    public static Date utcDate() {
//        String timeZone = LoginUserUtil.getTimeZone();
//        if (timeZone != null) {
//            return utcDate(timeZone);
//        }
//        return new Date();
//    }

//    public static Date deptUtcDate(String deptId) {
//        try {
//            return utcDate(SpringContextUtils.getBean(SysDeptService.class).selectByPrimaryKey(deptId).getConfig().getTimeZone());
//        } catch (Exception e) {
//            log.info("", e);
//            return new Date();
//        }
//    }

    public static Date utcDate(String timeZone) {
        String date = getDate("yyyy-MM-dd HH:mm:ss", timeZone);
        try {
            return parseDate(date);
        } catch (ParseException e) {
            log.info("", e);
        }

        return new Date();
    }

    public static Date utcChinaDate() {
        return utcDate("Asia/Shanghai");
    }

    public static String getDate(String pattern, String timeZone) {
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        return DateFormatUtils.format(new Date(), pattern, tz);
    }

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 当前时间的标准形式字符串
     */
    public static String now() {
        return DateUtil.now();
    }

    /**
     * @return : Date
     * @Description: 获取一天的开头
     */
    public static Date getStartOfDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.MINUTE, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.SECOND, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.MILLISECOND, 0);//设置为1号,当前日期既为本月第一天
        return c.getTime();
    }

    public static Date getFirstDayOfMouth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.MINUTE, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.SECOND, 0);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.MILLISECOND, 0);//设置为1号,当前日期既为本月第一天
        return c.getTime();
    }


    public static Date getLastDayOfMouth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);//加一个月
        c.set(Calendar.DAY_OF_MONTH, 0);//上个月的最后一天
        c.set(Calendar.HOUR_OF_DAY, 23);//23
        c.set(Calendar.MINUTE, 59);//59
        c.set(Calendar.SECOND, 59);//59
        c.set(Calendar.MILLISECOND, 999);//59
        return c.getTime();
    }

    /**
     * 判断两个日期相差的天数<br>
     *
     * <pre>
     * 有时候我们计算相差天数的时候需要忽略时分秒。
     * 比如：2016-02-01 23:59:59和2016-02-02 00:00:00相差一秒
     * 如果isReset为<code>false</code>相差天数为0。
     * 如果isReset为<code>true</code>相差天数将被计算为1
     * </pre>
     *
     * @param beginDate 起始日期
     * @param endDate   结束日期
     * @param isReset   是否重置时间为起始时间
     * @return 日期差
     * @since 3.0.1
     */
    public static long betweenDay(Date beginDate, Date endDate, boolean isReset) {

        return DateUtil.betweenDay(beginDate, endDate, isReset);
    }

    /**
     * 将日期字符串转换为{@link DateTime}对象，格式：<br>
     * <ol>
     * <li>yyyy-MM-dd HH:mm:ss</li>
     * <li>yyyy/MM/dd HH:mm:ss</li>
     * <li>yyyy.MM.dd HH:mm:ss</li>
     * <li>yyyy年MM月dd日 HH时mm分ss秒</li>
     * <li>yyyy-MM-dd</li>
     * <li>yyyy/MM/dd</li>
     * <li>yyyy.MM.dd</li>
     * <li>HH:mm:ss</li>
     * <li>HH时mm分ss秒</li>
     * <li>yyyy-MM-dd HH:mm</li>
     * <li>yyyy-MM-dd HH:mm:ss.SSS</li>
     * <li>yyyyMMddHHmmss</li>
     * <li>yyyyMMddHHmmssSSS</li>
     * <li>yyyyMMdd</li>
     * </ol>
     *
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date parse(String dateStr) {
        return DateUtil.parse(dateStr).toJdkDate();
    }

    /**
     * 获取日期对应的年份
     */
    public static int getYearByDate(Date date) {
        return DateUtil.year(date);
    }

    public static int getMonthByDate(Date date) {
        return DateUtil.month(date) + 1;
    }

//    public static String getStartOfYear() {
//        int year = getYearByDate(utcDate());
//        return year + "-01-01 00:00:00";
//    }
//
//    public static Date getStartOfYearDate() throws Exception {
//        return parseDate(getStartOfYear());
//    }
//
//    public static String getEndOfYear() {
//        int year = getYearByDate(utcDate());
//        String month = getMonthByDate(utcDate()) + "";
//        String day = DateUtil.dayOfMonth(utcDate()) + "";
//        if (month.length() < 2) {
//            month = "0" + month;
//        }
//        if (day.length() < 2) {
//            day = "0" + day;
//        }
//        return year + "-" + month + "-" + day + " 23:59:59";
//    }

    public static String buildDateFormat(String dateFormat) {
        switch (dateFormat) {
            case "year":
                return "%Y";
            case "month":
                return "%Y%m";
            case "day":
                return "%Y%m%d";
            case "weekend":
                return "%Y%u";
            default:
                return "%Y%m%d";
        }
    }

    /**
     * 日期转化为cron表达式
     *
     * @param date
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ?";
        return fmtDateToStr(date, dateFormat);
    }

    /**
     * cron表达式转为日期
     *
     * @param cron
     * @return
     */
    public static Date getCronToDate(String cron) {
        String dateFormat = "ss mm HH dd MM ?";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * Description:格式化日期,String字符串转化为Date
     */
    public static String fmtDateToStr(Date date, String dtFormat) {
        if (date == null)
            return "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
            return dateFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    public static Date defaultDate() {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, 0, 1, 0, 0, 0);
        Date date = instance.getTime();
        return date;
    }

    public static Date getFirstDayOfPeriod(Date date, int period) {
        int month = DateUtil.month(date);
        int cycle = month / period;//第几个周期
        month = cycle * period;//这个周期的起始月份是那个月
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);//设置为1号,当前日期既为本月第一天
        Date time = c.getTime();
        return DateUtil.beginOfMonth(time).toJdkDate();
    }

    public static Date getLastDayOfPeriod(Date date, int period) {
        int month = DateUtil.month(date);
        int cycle = month / period;//第几个周期
        month = (cycle + 1) * period;//这个周期的起始月份是那个月
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);//设置为1号,当前日期既为本月第一天
        Date time = c.getTime();
        return DateUtil.beginOfMonth(time).offset(DateField.SECOND, -1).toJdkDate();
    }

    public static long toSeconds() {
        return 0;
    }


//    public static String utcYearMonthDay() {
//        SimpleDateFormat yearMonthDayFormat = new SimpleDateFormat("yyyyMMdd");
//        return yearMonthDayFormat.format(utcDate());
//    }

    public static int betweenYear(String startTime, String endTime) {
        startTime = format(startTime);
        endTime = format(endTime);
        if (startTime == null || startTime.length() < 4 || endTime == null || endTime.length() < 4) return 1;
        return Math.abs(Integer.parseInt(startTime.substring(0, 4)) - Integer.parseInt(endTime.substring(0, 4))) + 1;
    }

    private static String format(String date) {
        date = replace(date, " ");
        date = replace(date, "/");
        date = replace(date, "-");
        date = replace(date, ":");
        return date;
    }

    private static String replace(String date, String regex) {
        if (date == null) return date;
        if (regex == null) return regex;
        if (date.contains(regex)) {
            return date.replaceAll(regex, "");
        }
        return date;
    }
//
//    public static String getSpaceOfYear(int spaceMonth) {
//        Date spaceDate = org.apache.commons.lang3.time.DateUtils.addMonths(utcDate(), spaceMonth);
//        int year = getYearByDate(spaceDate);
//        String month = getMonthByDate(spaceDate) + "";
//        if (month.length() < 2) {
//            month = "0" + month;
//        }
//        return year + "-" + month + "-" + "01 00:00:00";
//    }

    // 24*60*60*10000
    public static String buildTotalConst(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) return null;
        return DateUtil.formatBetween(startTime, endTime, BetweenFormater.Level.MILLSECOND);
    }
}
