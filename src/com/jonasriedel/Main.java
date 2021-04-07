package com.jonasriedel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Deutsch / English?");

        String language = sc.nextLine();

        if (language.equalsIgnoreCase("deutsch")) {

            System.out.println("Welche Rechenart möchtest du wählen? Addieren(+), Subtrahieren(-), Multiplizieren(*) oder Dividieren(/)");

            String input = sc.nextLine();

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
        }

        if (language.equalsIgnoreCase("english")) {

            System.out.println("Which type of calculation do you want to choose? Add (+), Subtract (-), Multiply (*) or Divide (/) ");

            String input = sc.nextLine();

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
        }
    }
}
