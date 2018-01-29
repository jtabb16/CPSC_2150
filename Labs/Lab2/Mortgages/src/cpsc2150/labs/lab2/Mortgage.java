package cpsc2150.labs.lab2;


/**
 * Created by kplis on 1/23/2018.
 */
public class Mortgage {



    private double houseCost;
    private double downPayment;
    private double percentDown;
    private int years;
    private double interestRate;
    private double payment;
    private Customer customer;

    Mortgage(double cost, double dp, int y, Customer cust)
    {


        /*
        Sets the house cost, down payment, years and customer. Calculates the percent down, rate, and payment
         */
    }

    private void calcRate()
    {
        /*
        Calculates the interest rate to use.
        The rate starts at the base rate of 2.5%
        If the loan is for 30 years, add the normal addition of 1%
        If the loan is for for less than 30 years, add the good addition of .5%
        The loan must be for 15, 20, 25 or 30 years

        Add the rate for the credit score based on the following table
        Credit rating | Credit score | add to rate
        Bad           | 0 - 500      | 10%
        Fair          | 500 - 599    | 5%
        Good          | 600 - 699    | 1%
        Great         | 700 - 749    | .5%
        Excellent     | 750 - 850    | 0%

        If the down payment is less than 20% of the price of the house, add .5%
         */


    }


    private void calcPayment()
    {
        /*
        Calculate the monthly payment
        terms:
        r - monthly rate - the interest rate divided by 12
        p - principal balance - the cost of the house minus the down payment
        n - number of payments - the total number of monthly payments

        monthly payment is (rp)/(1-(1+r)^-n)
         */

    }

    public boolean loanApproved()
    {
        /*
        If the intereset rate is too high (10% or higher) the loan is denied
        If the down payment is less than 3.5% of the price of the house then the loan is denied

        If the Debt to income ratio is above 40% the loan is denied
        The debt to income ratio is the total monthly debt payments (including the mortgage payment) / monthly income

        Otherwise the loan is approved
         */

        return true;
    }

    public double getPayment()
    {
        //return the monthly payment on the loan
        return 0;
    }

    public double getRate()
    {
        //return the interest rate on the loan
        return 0;
    }


    @Override
    public String toString()
    {
        //this function is provided
        //DO you need contracts for this?
        String str = "";
        if(loanApproved())
        {
            str += "Principal Amount: $" + (houseCost - downPayment) + "\n";
            str += "Interest Rate: " + (interestRate * 100) + "%\n";
            str += "Term: " + years + " years\n";
            str += "Monthly Payment: $" + payment + "\n";
        }
        else
        {
            str += "Loan was not approved";
        }
        return str;
    }

}
