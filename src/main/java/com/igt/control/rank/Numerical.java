package com.igt.control.rank;

import java.util.List;
import com.igt.entity.Avvenimento;

public class Numerical implements Rank<Avvenimento> {

    public void doRanking(List<Avvenimento> avvenimentos) {
        for (Avvenimento avvenimento : avvenimentos) {
            int idx = avvenimentos.lastIndexOf(avvenimento);
            avvenimento.setRank(idx + 1);
        }
    }

}