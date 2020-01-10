package com.example.springboot2.yang.demo;

import java.text.SimpleDateFormat;
import java.util.*;

public class DemoOne {

    public static void main(String[] args){
        List<String> dateList = getMondayCount("2018/01/01", "2018/01/31");
        dateList.forEach(time ->{
            System.out.println(time);
        });

    }
    public static List<String> getMondayCount(String from, String to)
    {
        Calendar calendar = Calendar.getInstance();
        String[] array = { from, to };
        Date[] ds = new Date[array.length];
        for(int i = 0; i < array.length; i++)
        {
            String[] fs = array[i].split("[^\\d]+");
            calendar.set(Integer.parseInt(fs[0]), Integer.parseInt(fs[1]) - 1, Integer.parseInt(fs[2]));
            ds[i] = calendar.getTime();
        }
        int count = 0;
        List<String> meetingDate = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(Date x = ds[0]; x.compareTo(ds[1]) <= 0;)
        {
            calendar.setTime(x);
            calendar.add(Calendar.DATE, 1);
            x = calendar.getTime();
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
            {
                meetingDate.add(simpleDateFormat.format(x));
                count++;
            }
        }
        return meetingDate;
    }
}
