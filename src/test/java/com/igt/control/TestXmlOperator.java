package com.igt.control;

import com.igt.control.sort.ByDateTimeDesc;
import com.igt.control.xml.ParseXml;
import com.igt.entity.Avvenimento;
import com.igt.control.sort.ByCodProgramaDesc;
import com.igt.control.xml.ParseXmlImpl;
import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class TestXmlOperator {

    private List<Avvenimento> avvenimentos;

    @Before
    public void parse_xml() throws Exception {
        ParseXml<Avvenimento> px = new ParseXmlImpl();
        this.avvenimentos = px.doParsing();
    }

    @Test
    public void sort_by_cod_programa_desc() throws Exception {

        XmlOperator<Avvenimento> xmlOperator = XmlOperator.init(avvenimentos).sort(new ByCodProgramaDesc());

        List<Avvenimento> out = xmlOperator.getItems();

        for (Avvenimento avvenimento : out) {
            System.out.println(
                    avvenimento.getCodPrograma() + "," +
                            avvenimento.getSiglaSport() + "," +
                            avvenimento.getDesManif() + "," +
                            avvenimento.getDesAvvenimento() + "," +
                            avvenimento.getDateTime()
            );
        }
    }


    @Test
    public void sort_by_date_time_desc() throws Exception {


        XmlOperator<Avvenimento> xmlOperator = XmlOperator.init(avvenimentos).sort(new ByDateTimeDesc());

        List<Avvenimento> out = xmlOperator.getItems();

        for (Avvenimento avvenimento : out) {
            System.out.println(
                    avvenimento.getCodPrograma() + "," +
                            avvenimento.getSiglaSport() + "," +
                            avvenimento.getDesManif() + "," +
                            avvenimento.getDesAvvenimento() + "," +
                            avvenimento.getDateTime()
            );
        }
    }

    @Test
    public void a_list_of_all_the_different_types_of_des_tipo_sco_divided_by_sigla_sport() throws Exception {
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

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Set<String> val = (HashSet<String>) entry.getValue();
            String a = StringUtils.join(val, ", ");

            System.out.println("sigla_sport =" + key + ":");
            System.out.println(a);
        }

    }
}
