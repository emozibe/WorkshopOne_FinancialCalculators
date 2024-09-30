// This program provides three different financial calculators.
// The user can choose which calculator to run and input the required data.

package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    // The main method allows the user to select a calculator and execute its functions.
    public static void main(String[] args) {
        // The while loop allows the program to continue until the user selects a valid option.
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

    // This method calculates and prints the mortgage monthly payment and total interest.
    public static void MortgageCalculator() {
        System.out.print("\nPlease enter the loan amount: ");
        float principal = scnr.nextFloat();
        System.out.print("Please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("Please enter the length of your loan term in months: ");
        float loanLength = scnr.nextFloat();

        // This calculation is based on the standard mortgage formula: M = P * (r * (1 + r)^n) / ((1 + r)^n - 1)
        // M = monthly payment, P = principal, r = yearly interest rate, n = number of monthly payments
        float monthlyPayment = (float) (principal * ((interest/12) * Math.pow(1 + (interest/12), loanLength))
                                        / (Math.pow(1 + (interest/12), loanLength) - 1));
        float totalInterest = (monthlyPayment * (loanLength)) - principal;

        System.out.printf("\nYour expected monthly payment would be: $%.2f", monthlyPayment);
        System.out.printf("\nYour total interest would be: $%.2f", totalInterest);
    }

    // This method calculates and prints the future value of a one-time deposit.
    public static void FutureValueCalculator() {
        System.out.print("\nPlease enter the deposit amount: ");
        float deposit = scnr.nextFloat();
        System.out.print("Please enter the interest rate as a decimal: ");
        float interest = scnr.nextFloat();
        System.out.print("Please enter the length of your deposit in years: ");
        float time = scnr.nextFloat();

        // This calculation is based on the compound interest formula: A = P * (1 + r / n)^(n * t)
        // A = final amount, P = principal, r = interest rate, n = number of times interest is compounded per year, t = number of years
        float futureValue = (float) (deposit * Math.pow(1 + interest, time));
        float totalInterest = futureValue - deposit;

        System.out.printf("\nYour expected future value would be: $%.2f", futureValue);
        System.out.printf("\nYour total interest would be: $%.2f", totalInterest);
    }

    // This method calculates and prints the present value of an ordinary annuity.
    public static void PresentValueCalculator() {
        System.out.print("\nPlease enter the monthly payout: ");
        double payout = scnr.nextDouble();
        System.out.print("Please enter the expected interest rate as a decimal: ");
        double interest = scnr.nextDouble();
        System.out.print("Please enter the length of your annuity in years: ");
        double years = scnr.nextDouble();

        // This calculation is based on the present value of an ordinary annuity formula: PV = P * (1 - 1 / (1 + r)^n) / r
        // PV = present Value, P = payment amount per period, r = interest rate per period, n = number of periods
        double presentValue = payout * (1 - (1 / Math.pow(1 + (interest / 12), (years * 12)))) / (interest / 12);

        System.out.printf("\nYour expected present value would be: $%.2f", presentValue);
    }
}