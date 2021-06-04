package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class Order {
    private BigDecimal orderAmount;
    private String state;
    private String county;

    public BigDecimal getOrderAmount() {
        Scanner input = new Scanner(System.in);
        double inputOrderAmount;
        do {
            System.out.println("Enter the order amount: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid order amount.");
                System.out.println("Enter the order amount: ");
            }
            inputOrderAmount = input.nextDouble();
            if (inputOrderAmount < 0) {
                System.out.println("Order amount cannot be a negative value.");
            }
        } while (inputOrderAmount < 0);
        orderAmount = BigDecimal.valueOf(inputOrderAmount);
        return orderAmount;
    }

    public String getState() {
        Scanner input = new Scanner(System.in);
        int numbers = 0;
        do {
            System.out.println("What state do you live in?");
            state = input.next();
            char[] digitTest = state.toCharArray();

            for (char c : digitTest) {
                if (Character.isDigit(c)) {
                    numbers = 1;
                }
            }

            if (numbers == 1) {
                System.out.println("State names cannot contain numbers");
                state = "";
                numbers = 0;
            }

        } while (state.length() < 1);

        return state;
    }

    public String getCounty() {
        Scanner input = new Scanner(System.in);
        int numbers = 0;
        do {
            System.out.println("What county do you live in?");
            county = input.nextLine();
            char[] digitTest = county.toCharArray();

            for (char c : digitTest) {
                if (Character.isDigit(c)) {
                    numbers = 1;
                }
            }
            if (numbers == 1) {
                System.out.println("County names cannot contain numbers");
                county = "";
                numbers = 0;
            }
        } while (county.length() < 1);

        return county;
    }

    public String calcTax() {
        orderAmount = getOrderAmount();
        state = getState();
        BigDecimal tax;
        BigDecimal total;
        String printTotal;
        String printTax;

        if (state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("WI")) {
            county = getCounty();
            BigDecimal countyTax;
            BigDecimal addTax;
            if (county.equalsIgnoreCase("Eau Claire")) {
                addTax = BigDecimal.valueOf(.005);
            } else if (county.equalsIgnoreCase("Dunn")) {
                addTax = BigDecimal.valueOf(.004);
            } else {
                addTax = BigDecimal.ZERO;
            }

            tax = orderAmount.multiply(BigDecimal.valueOf(.05));
            countyTax = orderAmount.multiply(addTax);
            tax = tax.add(countyTax);
            total = orderAmount.add(tax);
            tax = tax.setScale(2, RoundingMode.UP);
            printTax = NumberFormat.getCurrencyInstance().format(tax);
            System.out.println("The tax is " + printTax + ".");

        } else if (state.equalsIgnoreCase("Illinois") || state.equalsIgnoreCase("IL")) {
            tax = orderAmount.multiply(BigDecimal.valueOf(.08));
            total = orderAmount.add(tax);
            tax = tax.setScale(2, RoundingMode.UP);
            printTax = NumberFormat.getCurrencyInstance().format(tax);
            System.out.println("The tax is " + printTax + ".");

        } else {
            total = orderAmount;
        }

        total = total.setScale(2, RoundingMode.UP);
        printTotal = NumberFormat.getCurrencyInstance().format(total);
        return printTotal;

    }

}
