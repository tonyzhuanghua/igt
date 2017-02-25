package com.igt.control;

import com.igt.control.filter.Filter;
import com.igt.control.rank.Rank;
import com.igt.control.trans.TransToMap;

import java.util.*;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class Collation<T> {

    private List<T> items = new ArrayList<T>();
    private Map  maps = new HashMap();

    private Collation(List<T> sourceItems){
        items = new ArrayList<T>(sourceItems);
    }


    public static <T> Collation<T> init(List<T> sourceItems) {
        return new Collation<T>(sourceItems);
    }

    public Collation<T> sort(Comparator<T> sortComparator) {
        Collections.sort(items, sortComparator);
        return this;
    }
    public Collation<T> filter(Filter<T> filter, String val) {
        filter.doFilter(items, val);
        return this;
    }
    public Collation<T> rank(Rank<T> rank) {
        rank.doRanking(items);
        return this;
    }

    public Collation<T> trans(TransToMap<T> transToMap) {
        maps = transToMap.doTransing(items);
        return this;
    }


    public List<T> getItems() {
        return items;
    }

    public Map getMaps() {
        return maps;
    }
}
