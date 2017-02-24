package com.igt.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class XmlOperator<T> {

    private List<T> items = new ArrayList();

    private XmlOperator(List<T> sourceItems){
        items = new ArrayList<T>(sourceItems);
    }


    public static <T> XmlOperator<T> init(List<T> sourceItems) {
        return new XmlOperator<T>(sourceItems);
    }

    public XmlOperator<T> sort(Comparator<T> sortComparator) {
        Collections.sort(items, sortComparator);
        return this;
    }

    public T get(int i) {
        return this.items.get(i);
    }

    public List<T> getItems() {
        return items;
    }
}
