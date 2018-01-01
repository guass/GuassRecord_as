package www.guass.com.guassrecord.utils;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Date handler
 *
 * @author Jay
 */
public class DateUtils {

    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_HOUR_MINUTE = "HH:mm";
    public static final String PATTERN_HOUR_MINUTE_2 = "HHmm";
    public static final String PATTERN_HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String FULL_YEAR = "yyyy-MM-dd";
    public static final String FULL_YEAR_2 = "yyyyMMdd";
    public static final String FULL_YEAR_2_1 = "yyyy/MM/dd";
    public static final String FULL_YEAR_3 = "yyyyMMddHHmmss";
    public static final String FULL_YEAR_H_M = "yyyy-MM-dd HH:mm";
    public static final int WHEN_UNKNOWN = -2;
    public static final int WHEN_PAST = -1;
    public static final int WHEN_PRESENT = 0;
    public static final int WHEN_FUTURE = 1;

    /**
     * Return current date string in specified format.
     *
     * @param fmt string of required date format
     * @return
     */
    public static String currentInFormat(String fmt) {
        SimpleDateFormat sdft = new SimpleDateFormat(fmt);
        return sdft.format(Calendar.getInstance().getTime());
    }

    /**
     * Return current date string in specified format according timezone.
     *
     * @param fmt string of required date format
     * @return
     */
    public static String currentInFormat(String fmt, String timeZone) {
        SimpleDateFormat sdft = new SimpleDateFormat(fmt);
        Calendar cal = Calendar.getInstance();
        if (timeZone != null) sdft.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdft.format(cal.getTime());
    }

    /**
     * Return current date string in "HH:mm" format
     *
     * @return
     */
    public static String currentInShortFormat() {
        SimpleDateFormat fmt = new SimpleDateFormat(PATTERN_HOUR_MINUTE);
        return fmt.format(Calendar.getInstance().getTime());
    }

    /**
     * Return current date string in "yyyy-MM-dd" format
     *
     * @return
     */
    public static String currentInLongFormat() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(Calendar.getInstance().getTime());
    }

    /**
     * Return passed-in date in "yyyy-MM-dd HH:mm:ss" format string
     *
     * @param date
     * @return
     */
    public static String getDateInFullFormat(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat(PATTERN_FULL);
        return fmt.format(date);
    }


    /**
     * 获取日期是星期几
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDateForEn(String date) {
        String out = "";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date curDate = myFormatter.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(curDate);
            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY:
                    out = "Mon";
                    break;
                case Calendar.TUESDAY:
                    out = "Tue";
                    break;
                case Calendar.WEDNESDAY:
                    out = "Wed";
                    break;
                case Calendar.THURSDAY:
                    out = "Thu";
                    break;
                case Calendar.FRIDAY:
                    out = "Fri";
                    break;
                case Calendar.SATURDAY:
                    out = "Sat";
                    break;
                case Calendar.SUNDAY:
                    out = "Sun";
                    break;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return out;
    }

    /**
     * 获取当前日期是星期几
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDateForEn() {
        String out = "";
        Calendar cal = Calendar.getInstance();

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                out = "Mon";
                break;
            case Calendar.TUESDAY:
                out = "Tue";
                break;
            case Calendar.WEDNESDAY:
                out = "Wed";
                break;
            case Calendar.THURSDAY:
                out = "Thu";
                break;
            case Calendar.FRIDAY:
                out = "Fri";
                break;
            case Calendar.SATURDAY:
                out = "Sat";
                break;
            case Calendar.SUNDAY:
                out = "Sun";
                break;
        }
        return out;
    }

    private static boolean getLanguageEnv() {
        Locale l = Locale.getDefault();
        String language = l.getLanguage();
        String country = l.getCountry().toLowerCase();
        if ("zh".equals(language)) {
            if ("cn".equals(country)) {
                return false;
            } else if ("tw".equals(country)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据时区获取当前日期是星期几
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(String timeZone) {
        String out = "";
        Calendar cal = Calendar.getInstance();
        if (timeZone != null) cal.setTimeZone(TimeZone.getTimeZone(timeZone));
        boolean isEng = getLanguageEnv();

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                out = isEng ? "Mon" : "星期一";
                break;
            case Calendar.TUESDAY:
                out = isEng ? "Tue" : "星期二";
                break;
            case Calendar.WEDNESDAY:
                out = isEng ? "Wed" : "星期三";
                break;
            case Calendar.THURSDAY:
                out = isEng ? "Thu" : "星期四";
                break;
            case Calendar.FRIDAY:
                out = isEng ? "Fri" : "星期五";
                break;
            case Calendar.SATURDAY:
                out = isEng ? "Sat" : "星期六";
                break;
            case Calendar.SUNDAY:
                out = isEng ? "Sun" : "星期日";
                break;
        }
        return out;
    }

    /**
     * 获取当前日期是星期几
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate() {
        String out = "";
        Calendar cal = Calendar.getInstance();

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                out = "星期一";
                break;
            case Calendar.TUESDAY:
                out = "星期二";
                break;
            case Calendar.WEDNESDAY:
                out = "星期三";
                break;
            case Calendar.THURSDAY:
                out = "星期四";
                break;
            case Calendar.FRIDAY:
                out = "星期五";
                break;
            case Calendar.SATURDAY:
                out = "星期六";
                break;
            case Calendar.SUNDAY:
                out = "星期日";
                break;
        }
        if (getLanguageEnv()) {
            out = getWeekOfDateForEn();
        }
        return out;
    }

    /**
     * Check whether the time slot in the past, at present or in the future.
     *
     * @return -1：过去；0：当前；1：将来
     * @throws ParseException
     */
    public static int compareTime(String start, String end, String fmt) throws ParseException {
        SimpleDateFormat sfmt = new SimpleDateFormat(fmt);
        String now = sfmt.format(Calendar.getInstance().getTime());
        Date from = sfmt.parse(start);
        Date to = sfmt.parse(end);
        Date current = sfmt.parse(now);
        if (current.equals(to) || current.after(to)) {
            return WHEN_PAST;
        }
        if (current.equals(from) || (current.after(from) && current.before(to))) {
            return WHEN_PRESENT;
        }
        if (current.before(from)) {
            return WHEN_FUTURE;
        }
        return WHEN_UNKNOWN;
    }

    /**
     * Check whether the time slot in the past, at present or in the future.
     *
     * @return -1：过去；0：当前；1：将来
     * @throws ParseException
     */
    public static int compareTime(String start, String end, String cur, String fmt) throws ParseException {
        SimpleDateFormat sfmt = new SimpleDateFormat(fmt);
        Date from = sfmt.parse(start);
        Date to = sfmt.parse(end);
        Date current = sfmt.parse(cur);
        if (current.equals(to) || current.after(to)) {
            return WHEN_PAST;
        }
        if (current.equals(from) || (current.after(from) && current.before(to))) {
            return WHEN_PRESENT;
        }
        if (current.before(from)) {
            return WHEN_FUTURE;
        }
        return WHEN_UNKNOWN;
    }

    /**
     * Check whether the time slot in the past, at present or in the future.
     *
     * @return -1：过去；0：当前；1：将来
     * @throws ParseException
     */
    public static int compareTime(String start, String end, int day, String fmt) throws ParseException {
        SimpleDateFormat sfmt = new SimpleDateFormat(fmt);
        Calendar c = Calendar.getInstance();
        String now = sfmt.format(c.getTime());
        Date from = sfmt.parse(start);
        c.setTimeInMillis(from.getTime());
        c.add(Calendar.DAY_OF_MONTH, day);
        Date to = sfmt.parse(end);
        Date current = sfmt.parse(now);
        if (current.equals(to) || current.after(to)) {
            return WHEN_PAST;
        }
        if (current.equals(from) || (current.after(from) && current.before(to))) {
            return WHEN_PRESENT;
        }
        if (current.before(from)) {
            return WHEN_FUTURE;
        }
        return WHEN_UNKNOWN;
    }


    public static String getFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date(System.currentTimeMillis())) + "_" + currentInFormat("HH-mm-ss");
        return date;// 2012年10月03日 23:41:31
    }

    /**
     * log文件名，以当天命名
     * @return
     */
    public static String getLogFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;
    }

    public static String getDateEN() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = format1.format(new Date(System.currentTimeMillis()));
        return date1;// 2012-10-03 23:41:31
    }

    /**
     * 获取离指定日期相隔几天的日期
     *
     * @param currentDate 当前日期
     * @param days        相隔天数，前面的为负数，后面的为正
     * @return
     */
    public static String getDateOnDays(String currentDate, int days) {
        Date curDate;
        String date1 = null;
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            curDate = myFormatter.parse(currentDate);
            long milliseconds = curDate.getTime() + days * 24 * 3600 * 1000 + 5 * 1000;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliseconds);
            date1 = myFormatter.format(new Date(calendar.getTimeInMillis()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals("")) return 0;
        if (date2 == null || date2.equals("")) return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * @param time
     * @return
     */
    public static Date getServerTime(String time) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd.HHmmss");
        Date date = null;
        try {
            date = myFormatter.parse(time);
            return date;
        } catch (Exception e) {

        }

        return null;
    }

    /**
     * 比较两个时间前后
     *
     * @param st1 "HH:MM"的格式
     * @param st2 "HH:MM"的格式
     * @return boolean 第一个在后，返回true；否则返回false
     */
    public static boolean isFormerLater(String st1, String st2) {
        String[] kk = null;
        String[] jj = null;
        kk = st1.split(":");
        jj = st2.split(":");
        if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) return false;
        else {
            double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
            double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
            if ((y - u) > 0) return true;
            else return false;
        }
    }


    /**
     * 找出离当前时间最近的时间点
     *
     * @param time "HH:mm"的格式 ,返回"HH:mm"格式
     * @return
     */
    public static String findTime(String[] times, String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        int[] a = new int[times.length];

        for (int i = 0; i < times.length; i++) {
            a[i] = getIntervalTime(time, times[i]);

        }

        int index = findIndex(a);
        String s = times[index];
        return s;
    }


    /**
     * 比较时间,如果 time1 比 time2 晚返回 true
     *
     * @param time1 "HH:mm"的格式
     * @param time2 "HH:mm"的格式
     * @return
     */
    public static boolean compareTime(String time1, String time2) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            Date dt1 = simpleDateFormat.parse(time1);
            Date dt2 = simpleDateFormat.parse(time2);

            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 比较时间,如果 time1 比 time2 晚返回 true
     *
     * @param time1 "HH:mm"的格式
     * @param time2 "HH:mm"的格式
     * @return
     */
    public static boolean compareTime2(String time1, String time2, String format) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date dt1 = simpleDateFormat.parse(time1);
            Date dt2 = simpleDateFormat.parse(time2);

            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void selectSortTime(String[] times) {
        int size = times.length;
        String temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j >i; j--)  {
                if (getTimeLong(times[j] ,"HH:mm")< getTimeLong(times[k],"HH:mm"))  k = j;
            }
            temp = times[i];
            times[i] = times[k];
            times[k] = temp;
        }
    }

    public static long getTimeLong(String time, String fmt)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
        try
        {
            Date dt = simpleDateFormat.parse(time);
            return dt.getTime();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 获取time1 到达time2 的时间m
     *
     * @param time1 "HH:mm"的格式
     * @param time2 "HH:mm"的格式
     * @return
     */
    public static int getIntervalTime(String time1, String time2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        try {
            Date dt1 = simpleDateFormat.parse(time1);
            Date dt2 = simpleDateFormat.parse(time2);

            if (compareTime(time1, time2)) {
                int m = (int) ((dt1.getTime() - dt2.getTime()) / (60 * 1000));
                int result = 24 * 60 - m;
                return result;
            } else {
                int result = (int) ((dt2.getTime() - dt1.getTime()) / (60 * 1000));
                return result;

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }


    /**
     * 获取time1 到达time2 的时间m
     *
     * @param time1
     * @param time2
     * @param format
     * @return
     */
    public static int getIntervalTime(String time1, String time2, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            Date dt1 = simpleDateFormat.parse(time1);
            Date dt2 = simpleDateFormat.parse(time2);

            if (compareTime2(time1, time2, format)) {
                int m = (int) ((dt1.getTime() - dt2.getTime()) / (60 * 1000));
                int result = 24 * 60 - m;
                return result;
            } else {
                int result = (int) ((dt2.getTime() - dt1.getTime()) / (60 * 1000));
                return result;

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static int findIndex(int[] n) {
        int tmp = n[0];

        int k = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] < tmp) {
                tmp = n[i];
                k = i;
            }
        }
        return k;
    }

    public static String findRecentOnOffTime(String time) {
        if (TextUtils.isEmpty(time)) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String format = simpleDateFormat.format(new Date());

        String[] times = time.split(";");
        String result_off = DateUtils.findTime(times[1].split(","), format);
        String result_on = DateUtils.findTime(times[0].split(","), result_off);


        if (!TextUtils.isEmpty(result_on) && !TextUtils.isEmpty(result_off)) {
            return result_on + ";" + result_off;

        }
        return null;
    }

    public static Date getDate(String time, String fmt) {
        SimpleDateFormat sfmt = new SimpleDateFormat(fmt);
        try {
            return sfmt.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isOutBigTime(String[] times, String format) {
        String now = currentInFormat(format);
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            if (compareTime2(now, times[i], format)) {
                count++;
            }
        }
        if (count == times.length) {
            return true;
        }
        return false;
    }

    public static String findMinTime(String[] times, String format) {
        String tmp = times[0];
        int k = 0;
        for (int i = 0; i < times.length; i++) {
            if (!compareTime2(times[i], tmp, format)) {
                tmp = times[i];
                k = i;
            }
        }
        return times[k];
    }

    public static String findMinTime2(String[] times, String format) {
        String now = currentInFormat(format);
   //     Arrays.sort(times);
        selectSortTime(times);
        for (int i = 0; i < times.length; i++) {
            if (compareTime2(times[i], now, format)) {
                return times[i];
            }
        }
        return null;
    }

    public static String findMinTime2(String[] times, String time, String format) {
   //     Arrays.sort(times);
        selectSortTime(times);
        for (int i = 0; i < times.length; i++) {
            if (compareTime2(times[i], time, format)) {
                return times[i];
            }
        }
        return null;
    }


    public static int getM(String time) {
        int res = 0;
        String[] sp = time.split(":");
        int h = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        res = h * 60 + m;
        return res;
    }

    public static int getMinutes(String time) {
        int res = 0;
        String[] sp = time.split(":");
        int h = Integer.parseInt(sp[0].trim().toString());
        int m = Integer.parseInt(sp[1].trim().toString());
        res = h * 60 + m;

        return res;
    }

    /**
     * 获取当前时间+adds毫秒后的时间
     * @param adds
     * @param fmt
     * @return
     */
    public static String getDateTime(long adds,String fmt)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date = new Date(System.currentTimeMillis() + adds);
        return sdf.format(date);
    }

    public static String formatTime(long longTime,String fmt)
    {
        Date date = new Date(longTime);
        SimpleDateFormat sdft = new SimpleDateFormat(fmt);
        return sdft.format(date);
    }

    /**
     * 今天的日期 是单号 还是双号
     * @return
     */
    public static boolean isSingleDate(){
        Calendar rightNow = Calendar.getInstance();
        String[] data = rightNow.getTime().toString().split(" ");
        if(Integer.parseInt(data[2].toString()) % 2 == 0){
            return false;
        }else{
            return true;
        }
    }

}
