package com.catt.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description  
 * @Author hyk
 * @Date 2018/12/21 19:27
 **/
public class NextMonthDayUDF extends UDF {

    /**
     * ????·?????
     * @param date ????
     * @param num ?·?
     * @param day ????
     * @return
     */
    public Integer  evaluate(Integer  date, Integer  num,Integer  day){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date nowDate;
        Integer  re = 0;
        try {
            nowDate = format.parse(String.valueOf(date));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.add(Calendar.MONTH,num);
            if(day>0 && day<=31){
                calendar.set(Calendar.DAY_OF_MONTH,day);
            }
            Date fisrtDate = calendar.getTime();
            String fisrtStr = format.format(fisrtDate);
            re = Integer.parseInt(fisrtStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re;
    }

    public static void main(String [] args){
        System.out.println(new NextMonthDayUDF().evaluate(20181213,-1,0));

    }
}
