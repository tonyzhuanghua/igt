package com.igt.control;

import com.igt.control.sort.ByDateTimeDesc;
import com.igt.control.xml.ParseXml;
import com.igt.entity.Avvenimento;
import com.igt.control.sort.ByCodProgramaDesc;
import com.igt.control.xml.ParseXmlImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
}
