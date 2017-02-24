package com.igt.control.sort;

import com.igt.entity.Avvenimento;

import java.util.Comparator;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class ByCodProgramaDesc implements Comparator<Avvenimento> {
    public int compare(Avvenimento o1, Avvenimento o2) {

        int comparatorValue = 0;

        if (o1.getCodPrograma() < o2.getCodPrograma()) {
            comparatorValue = 1;
        } else if (o1.getCodPrograma() == o2.getCodPrograma()) {
            comparatorValue = 0;
        } else if (o1.getCodPrograma() > o2.getCodPrograma()) {
            comparatorValue = -1;
        }

        return  comparatorValue;


    }
}
