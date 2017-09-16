package z.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Title:
 *
 * @author ZhangZhongHe 2016年7月13日 Email:coo1943@126.com
 */

public class TimeUtil {

    public static String getCurrentTimeSceond() {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        return time;
    }

    public static Timestamp getAppiontedTimeStamp(int hour) {
        long currentTime = System.currentTimeMillis() + hour * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeTwoHour = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(beforeTwoHour);
        return timestamp;
    }

    /**
     * 获取指定时间的timestamp
     *
     * @param yyyyMMddHHmmss
     *
     * @return
     */
    public static Timestamp getAppointedDayTimeStamp(String yyyyMMddHHmmss, String format,int offset) {
        DateFormat df = new SimpleDateFormat(format);
        Date date;

        try {
            date = df.parse(yyyyMMddHHmmss);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long timestamp = cal.getTimeInMillis();
            timestamp=(timestamp+offset*24*60*60*1000L);
            Timestamp timestamp2 = new Timestamp(timestamp);
            return timestamp2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String getAfterTenTimeSceond() {

        long currentTime = System.currentTimeMillis() + 10 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        return nowTime;
    }


    public static Timestamp getAfterOneYear() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.add(Calendar.YEAR, +1);
        date = calendar.getTime();
        return new Timestamp(date.getTime());
    }

    /**
     * 获得两小时前的时间戳
     *
     * @return
     */
    public static Timestamp getBeforTweHourTimeSecond() {

        long currentTime = System.currentTimeMillis() - 2 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeTwoHour = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(beforeTwoHour);
        return timestamp;

    }

    /**
     * 获取一个月前的今天的时间戳
     *
     * @return 时间戳
     */
    public static Timestamp getBeforeOneMonthTimeSecond() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return new Timestamp(m.getTime());
    }

    /**
     * 获取本月第一天的时间戳
     *
     * @return 时间戳
     */
    public static Timestamp getMonthFirstSecond() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(year + "-" + month + "-01 00:00:01");
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取指定日期过去一天的时间戳
     *
     * @return 时间戳
     */
    public static Timestamp getAfterOneDayTimeSecond(Timestamp dataTime) {
        return  new Timestamp(dataTime.getTime()+24 * 60 * 60 * 1000);
    }

    public static Timestamp getbeforeOneDayTimeSecond(Timestamp dataTime) {
        return  new Timestamp(dataTime.getTime()-24 * 60 * 60 * 1000);
    }

    public static List<Timestamp> getPeriodDaysTime(Timestamp startTime, Timestamp endTime) {
        Timestamp index = getbeforeOneDayTimeSecond(startTime);
        List<Timestamp> list = new ArrayList<>();
        while (index.compareTo(endTime) <= 0) {
            index = getAfterOneDayTimeSecond(index);
            list.add(index);
        }
        return list;
    }


    public static String format(Timestamp timestamp){
        String time = timestamp+"";
        int start = time.indexOf("-")+1;
        int end = time.indexOf(" ");
        return time.substring(start,end);
    }

    public static void main(String[] args) {
        System.out.println(format(getCurrentTimestamp()));
    }

    /**
     * 获取n天偏移时间的开始时间戳
     *
     * @param n 天数
     *
     * @return 时间戳
     */
    public static Timestamp getNdiffDayStartTimeSecond(int n) {
        long currentTime = System.currentTimeMillis() + n * 24 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(date);
        return new Timestamp(convertDateSceond(time + " 00:00:00").getTime());
    }

    public static String getNdiffDayFormat(int n, String format) {
        long currentTime = System.currentTimeMillis() + n * 24 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        format = format == null ? "yyyy-MM-dd" : format;
        DateFormat df = new SimpleDateFormat(format);
        String time = df.format(date);
        return time;
    }


    /**
     * 获取今天开始时的时间戳
     *
     * @return 时间戳
     */
    public static Timestamp getDayStartSecond() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        return new Timestamp(convertDateSceond(time + " 00:00:00").getTime());
    }

    /**
     * 获取昨天
     *
     * @return 时间戳
     */
    public static Timestamp getYesterdayStartSecond() {
        long currentTime = System.currentTimeMillis() - 24 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(date);
        return new Timestamp(convertDateSceond(time + " 00:00:00").getTime());

    }


    /**
     * 本周第一天的开始时间戳
     *
     * @return
     */
    public static Timestamp getWeekStartTimestamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(date);
        return new Timestamp(convertDateSceond(time + " 00:00:00").getTime());
    }


    /**
     * 每月第一天时间戳
     *
     * @return 时间
     */
    public static Timestamp getMonthStartTimestamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String time = format.format(cal_1.getTime());
        return new Timestamp(convertDateSceond(time + " 00:00:00").getTime());
    }

    /**
     * 获取今天目前为止的小时时间
     *
     * @return
     */
    public static List<Timestamp> getTodayEachHourTime() {
        List<Timestamp> timestampList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        int hour = new Date().getHours();
        //获取前月的第一天
        for (int i = 0; i <= hour; i++) {
            cal_1.set(Calendar.HOUR_OF_DAY, i);
            String time = format.format(cal_1.getTime());
            timestampList.add(new Timestamp(convertDateSceond(time + ":00:00").getTime()));
            if (i == hour) {
                timestampList.add(new Timestamp(System.currentTimeMillis()));
            }
        }
        return timestampList;
    }


    public static List<Timestamp> getYesterdayEachHourTime() {
        long currentTime = System.currentTimeMillis() - 24 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String beforeTwoHour = df.format(date);
        List<Timestamp> timestampList = new ArrayList<>();
        int hour = 24;
        for (int i = 0; i <= hour; i++) {
            timestampList.add(new Timestamp(convertDateSceond(beforeTwoHour + " " + i + ":00:00").getTime()));
        }
        return timestampList;
    }

    public static String getDayHourFormat(Timestamp time, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date(time.getTime()));
    }



    /**
     * 获得两2天后的时间戳
     *
     * @return
     */
    public static Timestamp getAfterTweDaysTimeSceond() {

        long currentTime = System.currentTimeMillis() + 48 * 60 * 60 * 1000L;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeTwoHour = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(beforeTwoHour);
        return timestamp;

    }

    public static String getCurrentTimeMinute() {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(new Date());
        return time;
    }

    public static String getCurrentTimeDay() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        return time;
    }


    public static String getMonthTimeDay() {
        long currentTime = System.currentTimeMillis() - 15*24 * 60 * 60 * 1000L;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date(currentTime));
        return time;
    }

    public static String convertTimeSceond(Date date) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    public static String convertTimeDay(Date date) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }

    public static Date convertDateSceond(String time) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static Date convertDateDay(String time) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static boolean compDate(String date1, String date2) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean time = false;
        try {
            Date dates1 = format.parse(date1);
            Date dates2 = format.parse(date2);
            if (dates1.getTime() > dates2.getTime()) {
                time = true;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;
    }

    public static String getuniqukey() {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmsss");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 当前时间戳
     *
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }

    /**
     * 获取1970-1-1的时间戳
     *
     * @return
     */
    public static Timestamp getDefaultTimestamp() {
        return new Timestamp(623178000);
    }


    public static String getY_M_D() {
        return getYear() + "_" + getMonth() + "_" + getDay();
    }

    public static String getY_M() {
        return getYear() + "_" + getMonth();
    }

    public static String getDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "";
    }

    public static String getMonth() {
        return (Calendar.getInstance().get(Calendar.MONTH) + 1) + "";
    }

    public static String getYear() {
        return Calendar.getInstance().get(Calendar.YEAR) + "";
    }

}
