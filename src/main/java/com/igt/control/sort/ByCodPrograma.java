package com.igt.control.sort;

import com.igt.entity.Avvenimento;

import java.util.Comparator;

import static com.igt.control.sort.Direction.ASCENDING;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class ByCodPrograma implements Comparator<Avvenimento> {

    private Direction direction;

    public ByCodPrograma(){
        this.direction = ASCENDING;
    }

    public ByCodPrograma(Direction direction){
        this.direction = direction;
    }


    public int compare(Avvenimento o1, Avvenimento o2) {

        int comparatorValue = 0;

        if (o1.getCodPrograma() < o2.getCodPrograma()) {
            comparatorValue = 1;
        } else if (o1.getCodPrograma() == o2.getCodPrograma()) {
            comparatorValue = 0;
        } else if (o1.getCodPrograma() > o2.getCodPrograma()) {
            comparatorValue = -1;
        }

        return  direction.getDirection() * comparatorValue;


    }
}
