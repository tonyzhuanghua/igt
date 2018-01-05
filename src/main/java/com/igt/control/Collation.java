package com.igt.control;

import com.igt.control.filter.Filter;
import com.igt.control.rank.Rank;
import com.igt.control.trans.TransToMap;

import java.util.*;

/**
 * Created by zhuanghua on 2017/2/24.
 * 这个类的目的是使用一个静态方法init(List<T> sourceItems)返回一个Collation实例，
 * 然后对这个实例中两个私有变量，比如集合List<T>进行sort,rank,filter等操作
 * 操作完毕后仍然this，即返回这个Collation类的实例，仍然包含两个变量List<T>和Map，得以供给下次操作
 * 这个方法可以看成一个facade模式，因为facade模式就是通过一个类，来控制下面的子系统。
 * 对于调用这个Collation类的子系统，它们不用直接和实际操作的类打交道，而是通过Collation这个facade来打交道
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
