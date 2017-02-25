package com.igt.test;

import com.igt.test.TestCollation;

import java.util.Scanner;

/**
 * Created by zhuanghua on 2017/2/25.
 */
public class TestSuite {

    public static void main(String[] args) {

        TestCollation testCollation = new TestCollation();
        try {
            testCollation.parse_xml();
            System.out.println("\n\n\n\n-----------------------------------------------------------------------------------");
            System.out.println(" 1. A list ordered by cod_programa in descendent order of the events  ");
            System.out.println("-----------------------------------------------------------------------------------");

            testCollation.sort_by_cod_programa_desc();


            System.out.println("\n\n\n\n-----------------------------------------------------------------------------------");
            System.out.println(" 2. A list ordered by dateTime in descending order of the events      ");
            System.out.println("-----------------------------------------------------------------------------------");


            testCollation.sort_by_date_time_desc();


            System.out.println("\n\n\n\n-----------------------------------------------------------------------------------");
            System.out.println(" 3. A list of all the different types of des_tipo_sco divided by sigla_sport ");
            System.out.println("-----------------------------------------------------------------------------------");




            testCollation.a_list_of_all_the_different_types_of_des_tipo_sco_divided_by_sigla_sport();



            System.out.println("\n\n\n\n-----------------------------------------------------------------------------------");
            System.out.println(" 4. Output of the different sigla_sport based on the user input ");
            System.out.println("-----------------------------------------------------------------------------------");



            System.out.println("Please input: 1 for CALCIO, 2 for TENNIS\n");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            if (str.equals("1")) {

                testCollation.filter_by_sigla_sport_with_CALCIO();

                System.out.println("\nPlease input CALCIO number to display the program\n");

            } else if (str.equals("2")) {
                testCollation.filter_by_sigla_sport_with_TENNIS();
                System.out.println("\nPlease input TENNIS number to display the program\n");
            }

            Scanner scanner1 = new Scanner(System.in);
            testCollation.listDesTipoSco(scanner1.nextLine());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
