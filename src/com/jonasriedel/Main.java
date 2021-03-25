package com.jonasriedel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            System.out.println(zahl1 + " + " + zahl2 + " = " +  summe);
            System.out.println("Ergebnis: " + summe);
        }

        if (input.equalsIgnoreCase("subtrahieren") || input.equalsIgnoreCase("-")) {
            System.out.println("Erste Zahl:");
            int zahl1 = sc.nextInt();
            System.out.println("Zweite Zahl:");
            int zahl2 = sc.nextInt();
            int summe = zahl1 - zahl2;
            System.out.println(zahl1 + " - " + zahl2 + " = " +  summe);
            System.out.println("Ergebnis: " + summe);
        }

        if (input.equalsIgnoreCase("multiplizieren") || input.equalsIgnoreCase("*")) {
            System.out.println("Erste Zahl:");
            int zahl1 = sc.nextInt();
            System.out.println("Zweite Zahl:");
            int zahl2 = sc.nextInt();
            int summe = zahl1 * zahl2;
            System.out.println(zahl1 + " * " + zahl2 + " = " +  summe);
            System.out.println("Ergebnis: " + summe);
        }

        if (input.equalsIgnoreCase("dividieren") || input.equalsIgnoreCase("/")) {
            System.out.println("Erste Zahl:");
            int zahl1 = sc.nextInt();
            System.out.println("Zweite Zahl:");
            int zahl2 = sc.nextInt();
            int summe = zahl1 / zahl2;
            System.out.println(zahl1 + " / " + zahl2 + " = " +  summe);
            System.out.println("Ergebnis: " + summe);
        }
    }
}
