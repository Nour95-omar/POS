package se.kth.iv1350.startUp;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.InvalidItemIdentifierException;
import se.kth.iv1350.view.View;

/**
 *
 * @author nourbshar
 *starts the entire applications
 */
public class Main {
    /**
     * the main method used to start the applications
     * @param args the application does not have any parameters.
     */
   public static void main(String[]args) 
    {
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
        System.out.println("Unable to start the application");
   }


}


