package com.jonasriedel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Translation t;

    public static void main(String[] args) {
        t = new Translation();

        if (!t.loadConfig("/com/jonasriedel/assets/german.json")) {
            System.err.println("File could not be loaded from the specified path");
            System.exit(1);
        }

        if (!t.loadConfig("/com/jonasriedel/assets/english.json")) {
            System.err.println("File could not be loaded from the specified path");
            System.exit(1);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Deutsch (D) / English (E)?");

        String language = sc.nextLine();

        if (language.toLowerCase().matches(t.getValue("language_alias", "german"))) {
            calculator("german");
        } else if (language.toLowerCase().matches(t.getValue("language_alias", "english"))) {
            calculator("english");
        }
    }

    public static void calculator(String language) {
        Scanner sc = new Scanner(System.in);

        System.out.println(t.getValue("choose_calculation", language));
        String input = sc.nextLine();

        try {
            if (input.toLowerCase().matches(t.getValue("calc_type.add", language))) {
                System.out.println(t.getValue("first_number", language));
                int zahl1 = sc.nextInt();
                System.out.println(t.getValue("second_number", language));
                int zahl2 = sc.nextInt();
                int summe = zahl1 + zahl2;
                System.out.println(zahl1 + " + " + zahl2 + " = " + summe);
                System.out.println(t.getValue("result", language).replaceAll("<result>", String.valueOf(summe)));
            }

            if (input.toLowerCase().matches(t.getValue("calc_type.subtract", language))) {
                System.out.println(t.getValue("first_number", language));
                int zahl1 = sc.nextInt();
                System.out.println(t.getValue("second_number", language));
                int zahl2 = sc.nextInt();
                int summe = zahl1 - zahl2;
                System.out.println(zahl1 + " - " + zahl2 + " = " + summe);
                System.out.println(t.getValue("result", language).replaceAll("<result>", String.valueOf(summe)));
            }

            if (input.toLowerCase().matches(t.getValue("calc_type.multiply", language))) {
                System.out.println(t.getValue("first_number", language));
                int zahl1 = sc.nextInt();
                System.out.println(t.getValue("second_number", language));
                int zahl2 = sc.nextInt();
                int summe = zahl1 * zahl2;
                System.out.println(zahl1 + " * " + zahl2 + " = " + summe);
                System.out.println(t.getValue("result", language).replaceAll("<result>", String.valueOf(summe)));
            }

            if (input.toLowerCase().matches(t.getValue("calc_type.divide", language))) {
                System.out.println(t.getValue("first_number", language));
                int zahl1 = sc.nextInt();
                System.out.println(t.getValue("second_number", language));
                int zahl2 = sc.nextInt();

                if ((zahl2 == 0)) {
                    System.out.println(t.getValue("divide_by_zero", language));
                } else {
                    int summe = zahl1 / zahl2;
                    System.out.println(zahl1 + " / " + zahl2 + " = " + summe);
                    System.out.println(t.getValue("result", language).replaceAll("<result>", String.valueOf(summe)));
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(t.getValue("number_too_long", language));
            calculator(language);
        }

        Scanner nochmal = new Scanner(System.in);

        while (true) {
            System.out.println(t.getValue("again", language));

            String entscheidung = nochmal.nextLine();

            if (entscheidung.toLowerCase().matches(t.getValue("confirm", language))) {
                calculator(language);
            } else if (entscheidung.toLowerCase().matches(t.getValue("deny", language))) {
                System.out.println(t.getValue("goodbye", language));
                System.exit(0);
            }
        }
    }

    public static void englishCalculator() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which type of calculation do you want to choose? Add (+), Subtract (-), Multiply (*) or Divide (/)");

        String input = sc.nextLine();
        try {
            if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/") &&
                    !input.toLowerCase().contains("add") && !input.toLowerCase().contains("subtract") &&
                    !input.toLowerCase().contains("multiply") && !input.toLowerCase().contains("divide")) {
                System.out.println("`" + input + "´" + " is not a valid calculation type .");
                return;
            }

            if (input.equalsIgnoreCase("add") || input.equalsIgnoreCase("+")) {
                System.out.println("First number:");
                int zahl1 = sc.nextInt();
                System.out.println("Second number:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 + zahl2;
                System.out.println(zahl1 + " + " + zahl2 + " = " + summe);
                System.out.println("Result: " + summe);
            }

            if (input.equalsIgnoreCase("subtract") || input.equalsIgnoreCase("-")) {
                System.out.println("First number:");
                int zahl1 = sc.nextInt();
                System.out.println("Second number:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 - zahl2;
                System.out.println(zahl1 + " - " + zahl2 + " = " + summe);
                System.out.println("Result: " + summe);
            }

            if (input.equalsIgnoreCase("multiply") || input.equalsIgnoreCase("*")) {
                System.out.println("First number:");
                int zahl1 = sc.nextInt();
                System.out.println("Second number:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 * zahl2;
                System.out.println(zahl1 + " * " + zahl2 + " = " + summe);
                System.out.println("Result: " + summe);
            }

            if (input.equalsIgnoreCase("divide") || input.equalsIgnoreCase("/")) {
                System.out.println("First number:");
                int zahl1 = sc.nextInt();
                System.out.println("Second number:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 / zahl2;
                System.out.println(zahl1 + " / " + zahl2 + " = " + summe);
                System.out.println("Result: " + summe);
            }
        } catch (InputMismatchException e) {
            System.out.println("Number too long... Try again!");
            englishCalculator();
        }

        Scanner again = new Scanner(System.in);

        while (true) {
            System.out.println("That was nice! Again? Y/N");

            String choice = again.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                englishCalculator();
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("See you :)");
                System.exit(0);
            }
        }
    }
}
