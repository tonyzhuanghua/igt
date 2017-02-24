package com.igt.control.sort;

import com.igt.entity.Avvenimento;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class ByDateTimeDesc implements Comparator<Avvenimento> {
    public int compare(Avvenimento o1, Avvenimento o2) {

        int comparatorValue = 0;


        String d1 = o1.getDateTime();
        String d2 = o2.getDateTime();

        if (d1.compareTo(d2) < 0) {
            comparatorValue = 1;
        } else if (d1.compareTo(d2) == 0) {
            comparatorValue = 0;
        } else if (d1.compareTo(d2) > 0) {
            comparatorValue = -1;
        }

        return comparatorValue;


    }
}
