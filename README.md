### Calculator Project

This project has three calculators:
1. Mortgage Calculator
2. Future Value Calculator
3. Present Value of an Annuity Calculator

Users can select which calculator they want, enter some basic information like loan amount or interest rate, and the program will calculate results for them.

## Screenshots

# Home Screen

![Home Screen](D:\pluralsight\java-development\workshops\WorkshopOne_FinancialCalculators\Screenshots\home.png)

# Mortgage Calculator

![Mortage Calculator](D:\pluralsight\java-development\workshops\WorkshopOne_FinancialCalculators\Screenshots\mortgage.png)

# Future Value Calculator

![Future Value Calculator](D:\pluralsight\java-development\workshops\WorkshopOne_FinancialCalculators\Screenshots\futurevalue.png)

# Present Value of an Annuity Calculator

![Present Value Calculator](D:\pluralsight\java-development\workshops\WorkshopOne_FinancialCalculators\Screenshots\presentvalue.png)

# Error Screen

![Error Screen](D:\pluralsight\java-development\workshops\WorkshopOne_FinancialCalculators\Screenshots\error.png)

## Interesting Code Snippet

Here’s a part of the code that calculates mortgage payments:

float monthlyPayment = (float) (principal * ((interest/12) * Math.pow(1 + (interest/12), loanLength))
                                / (Math.pow(1 + (interest/12), loanLength) - 1));

The mortgage calculator is interesting because it simplifies complex financial calculations into just a few lines of code, making it easy to calculate monthly payments. It highlights how simple code can solve real-world problems quickly and efficiently.