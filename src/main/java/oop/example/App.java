package oop.example;


public class App 
{
    public static void main( String[] args )
    {
        Order user = new Order();
        System.out.println("The total is "+user.calcTax()+".");

    }
}
