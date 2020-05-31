package se.kth.iv1350.view;

import se.kth.iv1350.Util.FileLogHandler;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.DatabaseFailureException;
import se.kth.iv1350.integration.InvalidItemIdentifierException;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Receipt;


/**
 * this is a placeholder for the real view.
 * It contains a hard coded execution with calls to all system operations in the controller.
 *
 * @author nourbshar
 */
public class View {
    private Controller contr;
    private FileLogHandler logs;
    private ErrorMessageHandler errorMessageHandler;


    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
        this.logs = FileLogHandler.getLogger(); //new FileLogHandler();
        this.errorMessageHandler = new ErrorMessageHandler();
        contr.addPaymentObserver(new TotalRevenueView());
    }


    public void startTheSale() {
        System.out.println("Sample Execution To Sale Process");
        contr.startNewSale();
        System.out.println("A new sale has been started");
    }


    /**
     * Performs a fake sale by calling all the system operations in the controller.
     *
     * @throws InvalidItemIdentifierException if the searched item does not exist in the store.
     * @throws OperationFailedException       if an operation fails for unknown reason
     */
    public void runFakeExecution() throws OperationFailedException, InvalidItemIdentifierException, DatabaseFailureException {
        startTheSale();
        int newItem = 0;
        try {
            System.out.println("The cashier enters new items.\n");
            contr.enterNewItem(123456, 1); //This is correct
            contr.enterNewItem(7604676, 1); //This will throw an exception

        } catch (InvalidItemIdentifierException exc) {
            handleException("This product: " + newItem + " does not exist in the store", exc);
            return; //TODO is that what is the teacher want?
        }
        catch (DatabaseFailureException databaseFailureException) {
            handleException("Something went wrong, please contact the supervisor ", databaseFailureException);
            return;
        }
        System.out.println("The customer pay for the current sale");
        double paid = 400;


        try {
            double change = contr.payForCurrentSale(paid); //TODO Catch operation excpetion and return
            Receipt receipt = contr.receiptRequest(paid, change);
            Printer.printReceipt(receipt);
        } catch (OperationFailedException operationFailedException) {
            handleException("Correctly failed to pay for the current sale, please try again ", operationFailedException);
        }


        contr.updateSystemCreater();
        System.out.println("Accounting system and Inventory system has been updated");
    }


    private void handleException(String Msg, Exception exc) {
        errorMessageHandler.showErrorMsg(Msg);
        logs.logException(exc);
    }


}
