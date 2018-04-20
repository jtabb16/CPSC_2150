package cpsc2150.guiLab;

/**
 * Jack Tabb and Sangram Kadam
 * CPSC 2150 Kevin Plis
 * Lab 10
 * 4/19/18
 */

public final class CalculatorController {

    private final Calculator model; //This is where the calculations happen
    private final CalculatorView view; //This is where the user interacts with our program, where we get data from, and where we display data

    // this is all the constructor needs to do
    public CalculatorController(Calculator m, CalculatorView v)
    {
        this.model = m;
        this.view = v;
    }

    /**
     * these process methods are how we will handle events and connect the view and the model
     * you will need to use the publicly available methods to interact with the view
     *
     * You will need to parse the input from the screen
     *
     * You will need to check for errors in the input (user does not provide input, user types "six" instead of 6)
     *
     * You will need to check requires clauses of the model's methods
     *
     * If bad input is provided, print an error message into the output
     *
     * The Double.parseDouble(string str) function will be useful
     * The Integer.parseInt(string str) function will be useful
     * The Double.toString(double d) function will be useful
     */

    public void processAdd()
    {
        String in1 = view.getInput1();
        String in2 = view.getInput2();

        //Check to see if the input is numeric
        if (isNumeric(in1) && isNumeric(in2))
        {
            //The data is numeric, so convert it to the appropriate data type
            //Add uses doubles
            Double input1 = Double.parseDouble(in1);
            Double input2 = Double.parseDouble(in2);

            //Check to see if data meets requires clause for Add
            //Add requires input1 and input2 to be a number and a double
            //So, we meet the requires clause

            //Pass the input to the model to get the appropriate answer
            // And display the answer to the user (After converting the answer from a double to a string)
            view.setOutput( Double.toString(model.add(input1, input2)) );
        }
        else
        {
            view.setOutput("ERROR Not a Number");
        }
    }

    public void processSubtract()
    {
        String in1 = view.getInput1();
        String in2 = view.getInput2();

        //Check to see if the input is numeric
        if (isNumeric(in1) && isNumeric(in2))
        {
            //The data is numeric, so convert it to the appropriate data type
            //Subtract uses doubles
            Double input1 = Double.parseDouble(in1);
            Double input2 = Double.parseDouble(in2);

            //Check to see if data meets requires clause for Subtract
            //Subtract requires input1 and input2 to be a number and a double
            //So, we meet the requires clause

            //Pass the input to the model to get the appropriate answer
            // And display the answer to the user (After converting the answer from a double to a string)
            view.setOutput( Double.toString(model.subtract(input1, input2)) );
        }
        else
        {
            view.setOutput("ERROR Not a Number");
        }
    }

    public void processMult()
    {
        String in1 = view.getInput1();
        String in2 = view.getInput2();

        //Check to see if the input is numeric
        if (isNumeric(in1) && isNumeric(in2))
        {
            //The data is numeric, so convert it to the appropriate data type
            //Multiply uses doubles
            Double input1 = Double.parseDouble(in1);
            Double input2 = Double.parseDouble(in2);

            //Check to see if data meets requires clause for Mulitply
            //Multiply requires input1 and input2 to be a number and a double
            //So, we meet the requires clause

            //Pass the input to the model to get the appropriate answer
            // And display the answer to the user (After converting the answer from a double to a string)
            view.setOutput( Double.toString(model.multiply(input1, input2)) );
        }
        else
        {
            view.setOutput("ERROR Not a Number");
        }
    }

    public void processDivide()
    {
        String in1 = view.getInput1();
        String in2 = view.getInput2();

        //Check to see if the input is numeric
        if (isNumeric(in1) && isNumeric(in2))
        {
            //The data is numeric, so convert it to the appropriate data type
            //Add uses doubles
            Double input1 = Double.parseDouble(in1);
            Double input2 = Double.parseDouble(in2);

            //Check to see if data meets requires clause for Divide
            //Divide requires input1 and input2 to be a number and a double
            //Also, Divide requires input2 != 0
            if (input2!=0)
            {
                //Pass the input to the model to get the appropriate answer
                // And display the answer to the user (After converting the answer from a double to a string)
                view.setOutput( Double.toString(model.divide(input1, input2)) );
            }
            else
            {
                view.setOutput("ERROR: Cannot Divide by Zero (0)");
            }
        }
        else
        {
            view.setOutput("ERROR: Not a Number");
        }
    }

    public void processPower()
    {
        String in1 = view.getInput1();
        String in2 = view.getInput2();

        //Doesn't matter what the initial value is because we will change the value to be the user input
        // AND not use it to call the function if it doesn't meet the requirements
        Double input1 = new Double(0);
        Integer input2 = new Integer(0);

        boolean runPower = true; //Only run the function if everything meets requirements

        //Check to see if the input is numeric
        if (isNumeric(in1) && isNumeric(in2))
        {
            //The data is numeric, so convert it to the appropriate data type
            //Power uses doubles
            input1 = Double.parseDouble(in1);

            if (isInteger(in2))
            {
                input2 = Integer.parseInt(in2);
            }
            else
            {
                runPower = false;
                view.setOutput("ERROR: Exponent Not an Integer");
            }

            //Check to see if data meets requires clause for Power
            //Power requires input1 and input2 to be a number
            // and input 1 to be a double
            // and input 2 to be an integer
            //Also, Power requires input1 <= 999 AND 0 <= input2 <= 100
            int powerMaxBaseVal = 999;
            int powerMinExpVal = 0;
            int powerMaxExpVal = 100;

            if ( !(input1 <= powerMaxBaseVal) )
            {
                runPower = false;
                view.setOutput("ERROR: Base Out of Range (Max is " + powerMaxBaseVal + ")");
            }

            if ( !((input2 >= powerMinExpVal) && (input2 <= powerMaxExpVal)) )
            {
                runPower = false;
                view.setOutput("ERROR: Exponent Out of Range (Range is " + powerMinExpVal + "-" + powerMaxExpVal + ")");
            }
        }
        else
        {
            runPower = false;
            view.setOutput("ERROR: Not a Number");
        }

        //If all of the data meets all of the requirements
        if (runPower)
        {
            //Pass the input to the model to get the appropriate answer
            // And display the answer to the user (After converting the answer from a double to a string)
            view.setOutput( Double.toString(model.power(input1, input2)) );
        }

    }

    public void processClear()
    {
        view.setInput1("");
        view.setInput2("");
        view.setOutput("");
    }

    //this function will use exceptions to check if a string is numeric
    //note, it is not very efficient, but its easy and efficiency is not the most important for this program
    private boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    //This function will use exceptions to see if a string is an integer
    private boolean isInteger(String str)
    {
        try
        {
            int i = Integer.parseInt(str);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
