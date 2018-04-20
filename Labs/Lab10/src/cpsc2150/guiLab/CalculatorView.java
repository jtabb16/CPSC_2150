package cpsc2150.guiLab;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;

/**
 * This is our view class. You have several methods available to help you with this lab. You do not need to,
 * and should not make any changes to this file
 */
public final class CalculatorView extends JFrame implements ActionListener {

    private CalculatorController controller;
    private final JTextArea inText1, inText2, outText;
    private final JButton addButton, subtractButton, multButton, divideButton, powerButton, clearButton;

    public CalculatorView()
    {
        super("Calculator");
        //set up widgets
        JPanel inputPanel = new JPanel(new GridLayout(1, 2));

        this.inText1 = new JTextArea("", 2, 20);
        this.inText2 = new JTextArea("", 2, 20);
        this.outText = new JTextArea("", 2, 40);

        this.inText1.setEditable(true);
        this.inText1.setLineWrap(true);
        this.inText2.setEditable(true);
        this.inText2.setLineWrap(true);
        this.inText1.setBorder(BorderFactory.createLineBorder(Color.black));
        this.inText2.setBorder(BorderFactory.createLineBorder(Color.black));

        this.outText.setEditable(false);
        this.outText.setLineWrap(true);

        inputPanel.add(inText1);
        inputPanel.add(inText2);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        this.addButton = new JButton("+");
        this.subtractButton = new JButton("-");
        this.multButton = new JButton("x");
        this.divideButton = new JButton("/");
        this.powerButton = new JButton("^");
        this.clearButton = new JButton("clear");

        this.addButton.addActionListener(this);
        this.subtractButton.addActionListener(this);
        this.multButton.addActionListener(this);
        this.divideButton.addActionListener(this);
        this.powerButton.addActionListener(this);
        this.clearButton.addActionListener(this);


        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(clearButton);

        //add all to screen
        this.setLayout(new GridLayout(3, 1));
        this.add(inputPanel);
        this.add(buttonPanel);
        this.add(outText);




        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getInput1()
    {
        return inText1.getText();
    }

    public void setInput1(String m)
    {
        inText1.setText(m);
    }

    public void setInput2(String m)
    {
        inText2.setText(m);
    }


    public String getInput2()
    {
        return inText2.getText();
    }

    public void setOutput(String m)
    {
        outText.setText(m);
    }


    public void registerObserver(CalculatorController cont)
    {
        this.controller = cont;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();

        if (source == this.addButton) {
            this.controller.processAdd();
        } else if (source == this.subtractButton) {
            this.controller.processSubtract();
        } else if (source == this.multButton) {
            this.controller.processMult();
        } else if (source == this.divideButton) {
            this.controller.processDivide();
        } else if (source == this.powerButton) {
            this.controller.processPower();
        } else if (source == this.clearButton) {
            this.controller.processClear();
        }

        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }
}
