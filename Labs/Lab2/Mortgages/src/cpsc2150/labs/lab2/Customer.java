package cpsc2150.labs.lab2;

/**
 * Created by kplis on 1/23/2018.
 */
public class Customer {
    private String name;

    private double monthlyDebtPayments;
    private double income;
    private int creditScore;
    private Mortgage loan;


    Customer( double debt, double inc, int score, String n)
    {

        /*
        Set the monthly debt payments, income, credit score and name
        Credit scores range from 0 - 850
         */


    }

    public boolean applyForLoan(double downPayment, double houseCost, int years)
    {
        //Take the parameters and apply for a loan. Save the loan details as the customers current loan
        // Return whether or not the loan was approved
        return true;

    }

    public double getRate()
    {
        //return the interest rate on the current loan
        return 0;
    }

    public double getMonthlyPay()
    {
        //return the monthly payment on the current loan
        return 0;
    }

    public double getMonthlyDebtPayments()
    {
        //return the customers monthly debt payments
        return 0;
    }

    public double getIncome()
    {
        //return the customers income
        return 0;
    }

    public int getCreditScore()
    {
        //return the customers credit score
        return 0;
    }


    @Override
    public String toString()
    {
        //this function is provided
        //DO you need contracts for this?
        String str = "";
        str += "Name: " + name + "\n";
        str += "Income: $" + income + "\n";
        str += "Credit Score: " + creditScore + "\n";
        str += "Monthly Debt: $" + monthlyDebtPayments + "\n";
        str += "Mortgage info: \n";
        //str += loan.toString();

        return str;

    }
}
