package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select a calculator from the list below -\n");
            System.out.println("Mortgage Calculator (M)");
            System.out.println("Future Value of a One-Time Deposit Calculator (F)");
            System.out.println("Present Value of an Ordinary Annuity Calculator (P)\n");
            System.out.print("Please enter the letter that corresponds with the calculator you would like to use: ");
            String selection = scnr.nextLine();

            if (selection.equalsIgnoreCase("M")) {
                MortgageCalculator();
                break;
            } else if (selection.equalsIgnoreCase("F")) {
                FutureValueCalculator();
                break;
            } else if (selection.equalsIgnoreCase("P")) {
                PresentValueCalculator();
                break;
            } else {
                System.out.println("\nInvalid input. Please try again.\n");
            }
        }
    }

    public static void MortgageCalculator() {
        System.out.print("\nPlease enter the loan amount: ");
        float principal = scnr.nextFloat();
        System.out.print("Please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("Please enter the length of your loan term in months: ");
        float loanLength = scnr.nextFloat();

        float monthlyPayment = (float) (principal * ((interest/12) * Math.pow(1 + (interest/12), loanLength))
                                        / (Math.pow(1 + (interest/12), loanLength) - 1));
        float totalInterest = (monthlyPayment * (loanLength)) - principal;

        System.out.printf("\nYour expected monthly payment would be: $%.2f", monthlyPayment);
        System.out.printf("\nYour total interest would be: $%.2f", totalInterest);
    }

    public static void FutureValueCalculator() {
        System.out.print("\n Please enter the deposit amount: ");
        float deposit = scnr.nextFloat();
        System.out.print("Please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("Please enter the length of your deposit in years: ");
        float time = scnr.nextFloat();

        float futureValue = (float) (deposit * Math.pow(1 + interest, time));
        float totalInterest = futureValue - deposit;

        System.out.printf("\nYour expected future value would be: $%.2f", futureValue);
        System.out.printf("\nYour total interest would be: $%.2f", totalInterest);
    }

    public static void PresentValueCalculator() {
        System.out.print("\nPlease enter the monthly payout: ");
        double payout = scnr.nextDouble();
        System.out.print("Please enter the expected interest rate as a decimal: ");
        double interest = scnr.nextDouble();
        System.out.print("Please enter the length of your annuity in years: ");
        double years = scnr.nextDouble();

        double presentValue = payout * (1 - (1 / Math.pow(1 + (interest / 12), (years * 12)))) / (interest / 12);

        System.out.printf("\nYour expected present value would be: $%.2f", presentValue);
    }
}