package org.renthouse.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by geely
 */
public class DateTimeUtil {

    //joda-time

    //str->Date
    //Date->str
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String HOUSEORDER_FORMAT = "yyyy-MM-dd";

    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    /**
     * 月份加
     * @param date
     * @return
     */
    public static String dateAddmonth(Date date,Integer amount){
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar ct=Calendar.getInstance();
//            ct.setTime(df.parse(date));
            ct.setTime(date);
            ct.add(Calendar.MONTH, amount);
            //return df.format(ct.getTime());
            return dateToStr(ct.getTime(),HOUSEORDER_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "日期错误";
    }


    public static void main(String[] args) {
        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2010-01-01 11:11:11","yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateAddmonth(new Date(),4));
    }


}
