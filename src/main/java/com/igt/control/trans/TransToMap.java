package com.igt.control.trans;

import java.util.List;
import java.util.Map;

/**
 * Created by zhuanghua on 2017/2/25.
 */
public interface TransToMap <T> {

    public Map doTransing(List<T> o);
}
