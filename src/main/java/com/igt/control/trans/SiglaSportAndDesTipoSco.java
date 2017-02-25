package com.igt.control.trans;

import com.igt.entity.Avvenimento;
import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Created by zhuanghua on 2017/2/25.
 */
public class SiglaSportAndDesTipoSco implements TransToMap<Avvenimento> {

    public Map doTransing(List<Avvenimento> avvenimentos) {

        Map<String, Set<String>> map = new HashMap<String, Set<String>>();

        for (Avvenimento avvenimento : avvenimentos) {
            String siglaSport = avvenimento.getSiglaSport();

            Set<String> set = map.get(siglaSport);

            if (set == null) {
                set = new HashSet<String>();
            }
            List<String> desTipoScos = avvenimento.getDesTipoSco();

            for (String desTipoSco : desTipoScos) {
                set.add(desTipoSco);
            }

            map.put(siglaSport, set);
        }
        return map;

    }
}

