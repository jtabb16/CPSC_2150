package cpsc2150.guiLab;

/**
 * Our calculator class with several methods available
 * You do not need to, and should not, make any changes to this file
 */
public class Calculator {

    public Calculator(){

    }

    /**
     *
     * @param x first number to add
     * @param y second number to add
     * @return the sum of x and y
     * @ensures add = x + y
     */
    public double add(double x, double y)
    {
        return x + y;
    }

    /**
     *
     * @param x number to subtract FROM
     * @param y the number to subtract
     * @return x minus y
     * @ensures subtract = x - y
     */
    public double subtract(double x, double y)
    {
        return x - y;
    }

    /**
     *
     * @param x the number to multiply
     * @param y the multiplier
     * @return the product of x and y
     * @ensures multiply = x * y
     */
    public double multiply(double x, double y)
    {
        return x * y;
    }

    /**
     *
     * @param x the number to divide
     * @param y the number to divide by
     * @return x dvided by y
     * @requires y != 0
     * @ensures divide = x / y
     */
    public double divide(double x, double y)
    {
        return x / y;

    }

    /**
     *
     * @param x the base number
     * @param y the power
     * @return x to the power of y
     * @requires x <= 999 and 0 <= y <= 100
     * @ensures power = x ^ y
     */
    public double power(double x, int y)
    {
        double total = 1;
        for(int i = 0; i < y; i++)
        {
            total = total * x;
        }
        return total;
    }
}
