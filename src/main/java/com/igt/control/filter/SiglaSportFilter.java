package com.igt.control.filter;

import com.igt.entity.Avvenimento;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuanghua on 2017/2/25.
 */
public class SiglaSportFilter implements Filter<Avvenimento> {
    public void doFilter(List<Avvenimento> avvenimentos, String val) {


        Iterator<Avvenimento> iter = avvenimentos.iterator();
        while(iter.hasNext()){
            Avvenimento o = iter.next();
            if(!o.getSiglaSport().equals(val)){
                iter.remove();
            }
        }


    }
}
