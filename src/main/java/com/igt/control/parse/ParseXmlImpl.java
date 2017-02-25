package com.igt.control.parse;

import com.igt.entity.Avvenimento;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuanghua on 2017/2/24.
 */
public class ParseXmlImpl implements ParseXml<Avvenimento> {


    public List<Avvenimento> doParsing() throws Exception {

        List<Avvenimento> avvenimentos = new ArrayList<Avvenimento>();

        SAXReader reader = new SAXReader();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Java_EE_Test.xml");

        Document document = reader.read(inputStream);
        Element root = document.getRootElement();

        Iterator it = root.elementIterator("avvenimento");
        while (it.hasNext()) {
            Avvenimento avvenimento = new Avvenimento();
            Element element = (Element) it.next();

            avvenimento.setCodPrograma(Integer.parseInt(element.attributeValue("cod_programma")));
            avvenimento.setDesAvvenimento(element.attributeValue("des_avvenimento"));
            avvenimento.setSiglaSport(element.attributeValue("sigla_sport"));
            avvenimento.setDesManif(element.attributeValue("des_manif"));


            Date date = new SimpleDateFormat("dd/MM/yy HH:mm").parse(element.attributeValue("dateTime"));
            String dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);

            avvenimento.setDateTime(dateTime);

            Iterator<Element> iterator = element.elementIterator("scommessa");
            List<String> desTipoSco = new ArrayList<String>();
            while (iterator.hasNext()) {
                Element e = iterator.next();
                desTipoSco.add(e.attributeValue("des_tipo_sco"));
            }

            avvenimento.setDesTipoSco(desTipoSco);

            avvenimentos.add(avvenimento);
        }

        return avvenimentos;
    }


}
