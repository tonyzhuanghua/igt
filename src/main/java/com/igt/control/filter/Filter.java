package com.igt.control.filter;

import java.util.List;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public interface Filter<T>{
    public void doFilter(List<T> collection, String val);
}
