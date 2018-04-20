package cpsc2150.guiLab;

/**
 * this class sets up out model view controller pattern
 * You do not need to, and should not, make any changes to this file
 */
public final class GuiLab {

    //private so the class cannot be instantiated
    private GuiLab(){

    }

    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculatorView view = new CalculatorView();

        CalculatorController controller = new CalculatorController(model, view);

        view.registerObserver(controller);


    }
}
