package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("mortgage calc (M)");
        System.out.println("future value calc (F)");
        System.out.println("present value calc (P)");
        System.out.print("enter selection: ");
        String selection = scnr.nextLine();

        if (selection.equalsIgnoreCase("M")) {
            MortgageCalculator();
        } else if (selection.equalsIgnoreCase("F")) {
            FutureValueCalculator();
        }
    }

    public static void MortgageCalculator() {
        System.out.print("please enter the loan amount: ");
        float principal = scnr.nextFloat();
        System.out.print("please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("please enter the length of your loan term in months: ");
        float loanLength = scnr.nextFloat();

        float monthlyPayment = (float) (principal * ((interest/12) * Math.pow(1 + (interest/12), loanLength))
                / (Math.pow(1 + (interest/12), loanLength) - 1));
        float totalInterest = (monthlyPayment * (loanLength)) - principal;

        System.out.printf("your expected monthly payment would be: $%.2f", monthlyPayment);
        System.out.printf("\nyour total interest would be: $%.2f", totalInterest);
    }

    public static void FutureValueCalculator() {
        System.out.print("please enter the deposit amount: ");
        float deposit = scnr.nextFloat();
        System.out.print("please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("please enter the length of your deposit in years: ");
        float time = scnr.nextFloat();

        float futureValue = (float) (deposit * Math.pow(1 + interest, time));
        float totalInterest = futureValue - deposit;

        System.out.printf("your expected future value would be: $%.2f", futureValue);
        System.out.printf("\nyour total interest would be: $%.2f", totalInterest);
    }

    public static void PresentValueCalculator() {
        System.out.print("please enter the monthly payout: ");
        float payout = scnr.nextFloat();
        System.out.print("please enter the expected interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("please enter the length of your annuity in years: ");
        float years = scnr.nextFloat();

        float presentValue = (float) payout * (1 - (1 / (Math.pow(1 + interest))))
    }
}