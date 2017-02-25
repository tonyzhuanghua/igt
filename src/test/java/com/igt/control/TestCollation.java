package com.igt.control;

import com.igt.control.filter.SiglaSportFilter;
import com.igt.control.rank.Numerical;
import com.igt.control.sort.ByDateTime;
import com.igt.control.parse.ParseXml;
import com.igt.control.sort.Direction;
import com.igt.control.trans.SiglaSportAndDesTipoSco;
import com.igt.entity.Avvenimento;
import com.igt.control.sort.ByCodPrograma;
import com.igt.control.parse.ParseXmlImpl;
import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class TestCollation {

    private List<Avvenimento> avvenimentos;
    private Map<String, List<String>> desTipoScoMap = new HashMap<String, List<String>>();

    @Before
    public void parse_xml() throws Exception {
        ParseXml<Avvenimento> px = new ParseXmlImpl();
        this.avvenimentos = px.doParsing();
    }

    @Test
    public void sort_by_cod_programa_desc() throws Exception {

        Collation<Avvenimento> collation = Collation.init(avvenimentos).sort(new ByCodPrograma(Direction.DESCENDING));

        List<Avvenimento> out = collation.getItems();

        displayAvv(out);
    }


    @Test
    public void sort_by_date_time_desc() throws Exception {

        Collation<Avvenimento> collation = Collation.init(avvenimentos).sort(new ByDateTime(Direction.DESCENDING));

        List<Avvenimento> out = collation.getItems();

        displayAvv(out);
    }

    private void displayAvv(List<Avvenimento> out){
        for (Avvenimento avvenimento : out) {
            System.out.println(
                    // avvenimento.getCodPrograma() + "," +
                    avvenimento.getSiglaSport() + ", " +
                            avvenimento.getDesManif() + ", " +
                            avvenimento.getDesAvvenimento() + ", " +
                            avvenimento.getDateTime()
            );
        }

    }

    @Test
    public void a_list_of_all_the_different_types_of_des_tipo_sco_divided_by_sigla_sport() throws Exception {

        Collation<Avvenimento> collation = Collation.init(avvenimentos).trans(new SiglaSportAndDesTipoSco());

        Map map = collation.getMaps();

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Set<String> val = (HashSet<String>) entry.getValue();

            System.out.println("sigla_sport =" + key + ":");
            System.out.println(StringUtils.join(val, ", "));
        }

    }


    @Test
    public void filter_by_sigla_sport_with_CALCIO() throws Exception {

        filterRun("CALCIO");

    }


    @Test
    public void filter_by_sigla_sport_with_TENNIS() throws Exception {

        filterRun("TENNIS");

    }

    private void filterRun(String val) {
        Collation<Avvenimento> collation = Collation.init(avvenimentos)
                .sort(new ByDateTime(Direction.ASCENDING))
                .filter(new SiglaSportFilter(), val)
                .rank(new Numerical());

        List<Avvenimento> out = collation.getItems();

        for (Avvenimento avvenimento : out) {
            desTipoScoMap.put(avvenimento.getRank() + "", avvenimento.getDesTipoSco());

            System.out.println(
                    avvenimento.getRank() + ". " +
                            avvenimento.getDesAvvenimento()
                            //+ ". " + avvenimento.getDateTime()
            );

        }
    }


    protected void listDesTipoSco(String input) {
        List<String> desTipoSco = desTipoScoMap.get(input);
        if (desTipoSco==null) return;
        int i = 0;
        for (String s : desTipoSco) {
            System.out.println( ++i + ". " + s );
        }

    }

}
