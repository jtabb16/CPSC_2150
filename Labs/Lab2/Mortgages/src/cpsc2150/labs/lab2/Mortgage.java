package cpsc2150.labs.lab2;


/**
 * Created by kplis on 1/23/2018.
 */
public class Mortgage {
    /**
     Sangram Kadam
     Jack Tabb
     */


    private double houseCost;
    private double downPayment;
    private double percentDown;
    private int years;
    private double interestRate;
    private double payment;
    private Customer customer;

    /**
     *
     * @param cost [is the amount of money that the house costs]
     * @param dp [is the down payment for the house's mortgage]
     * @param y [is the years that the customer has to pay off the mortgage]
     * @param cust [is the customer who this mortgage applies to]
     * @requires dp >= 0 and cost >= 0 and y >= 0
     *           and [cust is a complete customer object]
     * @ensures house cost = cost, down payment = dp, years to pay mortgage = y,
     *          and customer this mortgage applies to is cust
     */
    Mortgage(double cost, double dp, int y, Customer cust)
    {


        /*
        Sets the house cost, down payment, years and customer. Calculates the percent down, rate, and payment
         */
    }

    /**
     * @requires [credit score needs to be available]
     *           and base interest rate is 2.5%
     *           and loan is for 15, 20, 25 or 30 years
     * @ensures if loan is for 30 years: interest rate = 2.5% + 1.0% + (additional interest rate due to credit score)
     *          if loan is for < 30 years: interest rate = 2.5% + 0.5% + (additional interest rate due to credit score)
     *          and (additional interest rate due to credit score) = 0.0% if 750 < credit score < 850
     *          and (additional interest rate due to credit score) = 0.5% if 700 < credit score < 749
     *          and (additional interest rate due to credit score) = 1.0% if 600 < credit score < 699
     *          and (additional interest rate due to credit score) = 5.0% if 500 < credit score < 599
     *          and (additional interest rate due to credit score) = 10.0% if 0 < credit score < 500
     *          and if down payment < 20% of (price of house): interest rate = #(interest rate) + 0.5%
     */
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

    /**
     * @requires interest rate > 0
     *           and down payment < cost of house
     *           and number of monthly payments > 0
     * @ensures (monthly payment) = (rp)/(1-(1+r)^-n)
     *              [where r is monthly rate, p is principal balance, n is number of payments]
     *           and r = (interest rate) / 12
     *           and p = (cost of house) - (down payment)
     *           and n = (total number of monthly payments
     */
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

    /**
     * @requires (interest rate) > 0
     *           and (down payment) > 0
     *           and (total monthly debt payments) > 0
     *           and (monthly income) > 0
     * @ensures loanApproved = false if (interest rate) >= 10%
     *          and loanApproved = false if (down payment) < (.035) * (price of house)
     *          and loanApproved = false if (total monthly debt payments (including mortgage payment)) / (monthly income) > 40%
     *          and [loanApproved = true if otherwise]
     * @return  loanApproved = false if (interest rate) >= 10%
     *          and loanApproved = false if (down payment) < (.035) * (price of house)
     *          and loanApproved = false if (total monthly debt payments (including mortgage payment)) / (monthly income) > 40%
     *          and [loanApproved = true if otherwise]
     */
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

    /**
     * @requires [monthly payment for loan has a value]
     * @ensures getPayment = (monthly payment)
     * @return getPayment = (monthly payment)
     */
    public double getPayment()
    {
        //return the monthly payment on the loan
        return 0;
    }

    /**
     * @requires [interest rate has a value]
     * @ensures getRate = (interest rate on the loan)
     * @return getRate = (interest rate on the loan)
     */
    public double getRate()
    {
        //return the interest rate on the loan
        return 0;
    }

    /**
     * @requires [this, which is the Mortgage object that toString is acting on, is an initialized Mortgage object]
     *            and (house cost), (down payment), (interest rate), (years to pay mortgage), (monthly payment) > 0
     * @ensures if loanApproved = true, toString = [string containing info about the Mortgage object, with proper formatting
     *            and this information is "Principal Amount: $" + (house cost - down payment),
     *                                    "Interest Rate: " + (interest rate) * 100,
     *                                    "Term: " + (number of years) + "years",
     *                                    "Monthly Payment: $" + payment]
     *          if loanApproved = false, toString = "Loan was not approved"
     * @return if loanApproved = true, toString = [string containing info about the Mortgage object, with proper formatting
     *            and this information is "Principal Amount: $" + (house cost - down payment),
     *                                    "Interest Rate: " + (interest rate) * 100,
     *                                    "Term: " + (number of years) + "years",
     *                                    "Monthly Payment: $" + payment]
     *          if loanApproved = false, toString = "Loan was not approved"
     */
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
