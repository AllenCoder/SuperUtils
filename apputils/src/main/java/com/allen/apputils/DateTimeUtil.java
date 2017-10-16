/*
 * Copyright  2017 [AllenCoder]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.allen.apputils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Allen on 15-5-26.
 */
public class DateTimeUtil {
    private DateTimeUtil() {

    }

    private static final String DATE_TIME = "yyyy-MM-dd";
    private static final String DATE_TIME_HOUR = "HH:mm";
    private static final String DATE_TIME0 = "yyyy-MM-dd HH:mm";
    private static final String DATE_TIME1 = "MM-dd";
    private static final String DATE_TIME_MONTH = "MM-dd HH:mm:ss";
    private static final String DATE_Calendar = "yyyyMMdd";
    private static final String DATE_TIME_MILL = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_MILL_HOUR_MIN_MILL = "HH:mm:ss";
    private static final String T_HOUR = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * 获取期限名称
     *
     * @param type 1：日 2：周 3：月 4：季度 5：年
     * @return String
     */
    public static String getPeriodName(int type) {
        String result = "";
        switch (type) {
            case 1:
                result = "天";
                break;
            case 2:
                result = "周";
                break;
            case 3:
                result = "个月";
                break;
            case 4:
                result = "个季度";
                break;
            case 5:
                result = "年";
                break;
        }
        return result;
    }

    /**
     * 格式化时间（yyyy-MM-dd）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTime(long dateTime) {
        return formatDateTime(dateTime, DATE_TIME);
    }

    /**
     * 格式化时间（yyyy-MM-dd）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTime0(long dateTime) {
        return formatDateTime(dateTime, DATE_TIME0);
    }

    /**
     * 格式化时间（MM-dd）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTimeMonth(long dateTime) {
        return formatDateTime(dateTime, DATE_TIME1);
    }


    /**
     * 格式化时间（HH-mm）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTimeHour(long dateTime) {
        return formatDateTime(dateTime, DATE_TIME_HOUR);
    }


    /**
     * 格式化时间（HH:mm:mm）
     *
     * @param mill 参数秒
     * @return
     */
    public static String formatDateTimeHMM(long mill) {
        return formatDateTime(mill, DATE_TIME_MILL_HOUR_MIN_MILL);
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @param format
     * @return
     */
    public static String formatDateTime(long dateTime, String format) {
        Date date = new Date(dateTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @return
     */

    public static String formatDateTimeMill(long dateTime) {
        Date date = new Date(dateTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_MILL);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @return
     */

    public static String formatDateTimeMMSS(long dateTime) {
        Date date = new Date(dateTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_MONTH);
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDateTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_MILL);
        return simpleDateFormat.format(date);
    }

    public static String getCalendarTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_Calendar);
        return simpleDateFormat.format(date);
    }

    /**
     * 输入yyyy-MM-dd'T'HH:mm:ss
     * 输出: HH:mm
     *
     * @param time
     * @return
     */
    public static String formatTime(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(T_HOUR);
        Date date = sdf.parse(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_HOUR);
        return simpleDateFormat.format(date);
    }

    /**
     * 返回时间戳
     *
     * @param Time
     * @return
     */
    public static long getTimeMill(String Time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date date = format.parse(Time);


        return date.getTime();
    }

    /**
     * 获取 时间间隔 天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        //先算出两时间的毫秒数之差大于一天的天数
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));
        //使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        //比较两日期的DAY_OF_MONTH是否相等
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)) {
            //相等说明确实跨天了
            return betweenDays + 1;
        } else {
            //不相等说明确实未跨天
            return betweenDays;
        }
    }

}
