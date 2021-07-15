package com.jonasriedel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Translation translation;

    public static void main(String[] args) {
        translation = new Translation();

        if (!translation.loadConfig("/com/jonasriedel/assets/german.json")) {
            System.err.println("File could not be loaded from the specified path");
            System.exit(1);
        }

        if (!translation.loadConfig("/com/jonasriedel/assets/english.json")) {
            System.err.println("File could not be loaded from the specified path");
            System.exit(1);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Deutsch (D) / English (E)?");

        String language = sc.nextLine();

        if (language.toLowerCase().matches(translation.getValue("language_alias", "german"))) {
            calculator("german");
        } else if (language.toLowerCase().matches(translation.getValue("language_alias", "english"))) {
            calculator("english");
        }
    }

    public static double[] requestTwoNumbers(Scanner sc, String language) {
        System.out.println(translation.getValue("first_number", language));
        double zahl1 = sc.nextDouble();
        System.out.println(translation.getValue("second_number", language));
        double zahl2 = sc.nextDouble();
        return new double[]{zahl1, zahl2};
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    public static void calculator(String language) {
        Scanner sc = new Scanner(System.in);

        System.out.println(translation.getValue("choose_calculation", language));
        String calc_type = sc.nextLine();

        try {
            if (calc_type.toLowerCase().matches(translation.getValue("calc_type.add", language))) {
                double[] input = requestTwoNumbers(sc, language);
                double summe = input[0] + input[1];
                System.out.println(fmt(input[0]) + " + " + fmt(input[1]) + " = " + fmt(summe));
                System.out.println(translation.getValue("result", language).replaceAll("<result>", String.valueOf(fmt(summe))));
            }

            if (calc_type.toLowerCase().matches(translation.getValue("calc_type.subtract", language))) {
                double[] input = requestTwoNumbers(sc, language);
                double differenz = input[0] - input[1];
                System.out.println(fmt(input[0]) + " - " + fmt(input[1]) + " = " + fmt(differenz));
                System.out.println(translation.getValue("result", language).replaceAll("<result>", String.valueOf(fmt(differenz))));
            }

            if (calc_type.toLowerCase().matches(translation.getValue("calc_type.multiply", language))) {
                double[] input = requestTwoNumbers(sc, language);
                double produkt = input[0] * input[1];
                System.out.println(fmt(input[0]) + " * " + fmt(input[1]) + " = " + fmt(produkt));
                System.out.println(translation.getValue("result", language).replaceAll("<result>", String.valueOf(fmt(produkt))));
            }

            if (calc_type.toLowerCase().matches(translation.getValue("calc_type.divide", language))) {
                double[] input = requestTwoNumbers(sc, language);
                if ((input[1] == 0)) {
                    System.out.println(translation.getValue("divide_by_zero", language));
                } else {
                    double quotient = input[0] / input[1];
                    System.out.println(fmt(input[0]) + " / " + fmt(input[1]) + " = " + fmt(quotient));
                    System.out.println(translation.getValue("result", language).replaceAll("<result>", String.valueOf(fmt(quotient))));
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(translation.getValue("wrong_number_format", language));
            calculator(language);
        }

        Scanner nochmal = new Scanner(System.in);

        while (true) {
            System.out.println(translation.getValue("again", language));

            String entscheidung = nochmal.nextLine();

            if (entscheidung.toLowerCase().matches(translation.getValue("confirm", language))) {
                calculator(language);
            } else if (entscheidung.toLowerCase().matches(translation.getValue("deny", language))) {
                System.out.println(translation.getValue("goodbye", language));
                System.exit(0);
            }
        }
    }
}
