package com.letsfly.utils;

import java.time.LocalTime;

public class TimeUtils {

    /**
     * Add t1 & t2.
     * With overflow
     *
     * @param t1 LocalTime in format {@code java.time.LocalTime}
     * @param t2 LocalTime in format {@code java.time.LocalTime}
     * @return a {@code java.time.LocalTime} object
     */
    public static LocalTime addLocalTime(LocalTime t1, LocalTime t2) {
        
        int nH = t1.getHour()+t2.getHour();
        int nM = t1.getMinute()+t2.getMinute();
        int nS = t1.getSecond()+t2.getSecond();
        
        if (nS>=60){
            nS-=60;
            nM++;
        }
        if (nM>=60){
            nM-=60;
            nH++;
        }
        nH = nH>=24 ? nH-=24 : nH;

        LocalTime tt = LocalTime.of(nH,nM,nS);

        return tt;
    }

}
