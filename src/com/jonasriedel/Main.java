package com.jonasriedel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Deutsch / English?");

        String language = sc.nextLine();

        if (language.equalsIgnoreCase("deutsch")) {
            germanCalculator();
        }

        if (language.equalsIgnoreCase("english")) {
            englishCalculator();
        }
    }

    public static void germanCalculator() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welche Rechenart möchtest du wählen? Addieren(+), Subtrahieren(-), Multiplizieren(*) oder Dividieren(/)");

        String input = sc.nextLine();
        try {

            if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/") &&
                    !input.toLowerCase().contains("addieren") && !input.toLowerCase().contains("subtrahieren") &&
                    !input.toLowerCase().contains("multiplizieren") && !input.toLowerCase().contains("dividieren")) {
                System.out.println("`" + input + "´" + " ist keine gültige Rechenart.");
                return;
            }

            if (input.equalsIgnoreCase("addieren") || input.equalsIgnoreCase("+")) {
                System.out.println("Erste Zahl:");
                int zahl1 = sc.nextInt();
                System.out.println("Zweite Zahl:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 + zahl2;
                System.out.println(zahl1 + " + " + zahl2 + " = " + summe);
                System.out.println("Ergebnis: " + summe);
            }

            if (input.equalsIgnoreCase("subtrahieren") || input.equalsIgnoreCase("-")) {
                System.out.println("Erste Zahl:");
                int zahl1 = sc.nextInt();
                System.out.println("Zweite Zahl:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 - zahl2;
                System.out.println(zahl1 + " - " + zahl2 + " = " + summe);
                System.out.println("Ergebnis: " + summe);
            }

            if (input.equalsIgnoreCase("multiplizieren") || input.equalsIgnoreCase("*")) {
                System.out.println("Erste Zahl:");
                int zahl1 = sc.nextInt();
                System.out.println("Zweite Zahl:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 * zahl2;
                System.out.println(zahl1 + " * " + zahl2 + " = " + summe);
                System.out.println("Ergebnis: " + summe);
            }

            if (input.equalsIgnoreCase("dividieren") || input.equalsIgnoreCase("/")) {
                System.out.println("Erste Zahl:");
                int zahl1 = sc.nextInt();
                System.out.println("Zweite Zahl:");
                int zahl2 = sc.nextInt();
                int summe = zahl1 / zahl2;
                System.out.println(zahl1 + " / " + zahl2 + " = " + summe);
                System.out.println("Ergebnis: " + summe);
            }
        } catch (InputMismatchException e) {
            System.out.println("Zahl zu lang... Nochmal von vorne");
            germanCalculator();
        }

        Scanner nochmal = new Scanner(System.in);

        while (true) {
            System.out.println("Das war toll! Nochmal? J/N.");

            String entscheidung = nochmal.nextLine();

            if (entscheidung.equalsIgnoreCase("j")) {
                germanCalculator();
            } else if (entscheidung.equalsIgnoreCase("n")) {
                System.out.println("Wir sehen uns :)");
                System.exit(0);
            }
        }
    }

    public static void englishCalculator() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which type of calculation do you want to choose? Add (+), Subtract (-), Multiply (*) or Divide (/) ");

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
