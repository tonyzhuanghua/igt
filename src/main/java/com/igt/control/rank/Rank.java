package com.igt.control.rank;

import java.util.List;

/**
 * Created by zhuanghua on 2017/2/25.
 */
public interface Rank<T> {

    public void doRanking(List<T> collection);
}
