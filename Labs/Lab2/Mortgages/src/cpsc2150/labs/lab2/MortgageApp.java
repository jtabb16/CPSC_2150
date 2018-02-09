package cpsc2150.labs.lab2;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * CPSC 2150
 * Kevin Plis
 * Section 3
 * 2/2/2018
 * Lab 2
 */
public class MortgageApp {

    public static void main(String [] args)
    {
        Customer cust = new Customer(1200, 105000, 720, "John Campbell");
        cust.applyForLoan(8000, 145000, 30);
        System.out.println(cust.toString());
    }
}