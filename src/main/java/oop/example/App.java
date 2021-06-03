package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kate Ingraham
 */

public class App 
{
    public static void main( String[] args )
    {
        Order user = new Order();
        System.out.println("The total is "+user.calcTax()+".");

    }
}
