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

/**
 * @invariant monthlyDebtPayments > 0 and income > 0 and 0 <= creditScore <= 850 and loan has to be an object
 */
public class Customer {
    private String name;

    private double monthlyDebtPayments;
    private double income;
    private int creditScore;
    private Mortgage loan;



    /**
     * @param [debt is monthly payments]
     * @param [inc is income]
     * @param [score is credit score]
     * @param [n is name]
     * @requires 0<= credit <= 850 and debt >= 0 and income >= 0 and name != ""
     * @ensures monthly debt payments = debt and income = inc and score = score and name = n
     */
    Customer( double debt, double inc, int score, String n)
    {
        monthlyDebtPayments = debt;
        income = inc;
        creditScore = score;
        name = n;
    }

    /**
     * @param [downPayment is first payment that allows to get a loan]
     * @param [houseCost is the cost of the house]
     * @param [years is how many years customer is allowed to repay loan principal + interest]
     * @requires downPayment >= 0 and houseCost >= 0 and years >=0
     * @ensures applyForLoan is true iff years <= 30 and downPayment / houseCost > 0.1
     *          and applyForLoan is false if years > 30 or downPayment / houseCost <= 0.1
     * @returns applyForLoan is true iff years <= 30 and downPayment / houseCost > 0.1
     *          applyForLoan is false if years > 30 or downPayment / houseCost <= 0.1
     */
    public boolean applyForLoan(double downPayment, double houseCost, int years)
    {
        loan = new Mortgage(houseCost, downPayment, years, this);
        return loan.loanApproved();
    }

    /**
     * @requires interest rate > 0%
     * @ensures getRate = rate
     * @returns the interest rate on current loan
     */
    public double getRate()
    {
        return loan.getRate();
    }
    /**
     * @requires monthly pay > 0
     * @ensures getMonthlyPay = monthlyPayment
     * @returns the monthly payment on the current loan
     */
    public double getMonthlyPay()
    {
        return loan.getPayment();
    }

    /**
     * @requires monthly debt payments > 0
     * @ensures getMonthlyDebtPayments = monthlyDebtPayment
     * @returns the customers monthly debt payment
     */
    public double getMonthlyDebtPayments()
    {
        return monthlyDebtPayments;
    }
    /**
     * @requires income > 0
     * @ensures getIncome = income
     * @returns the customers income
     */
    public double getIncome()
    {
        return income;
    }
    /**
     * @requires monthly debt payments > 0
     * @ensures getCreditScore = creditScore
     * @returns the customers credit score
     */
    public int getCreditScore()
    {
        return creditScore;
    }


    /**
     * @requires name, income, creditScore, and monthlyDebtPayments
     * @ensures [information about Customer object]
     * @returns [information about the customer and loan]
     */
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
        if (loan != null) {
            str += loan.toString();
        }

        return str;
    }
}