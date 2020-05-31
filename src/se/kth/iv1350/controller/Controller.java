package se.kth.iv1350.controller;

import se.kth.iv1350.Util.FileLogHandler;
import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.CashRegistry;
import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.SaleInformation;
import se.kth.iv1350.view.ErrorMessageHandler;
import se.kth.iv1350.model.PaymentObserver;

import java.util.ArrayList;
import java.util.List;




/**
 * @author nourbshar
 * this is the application's only controller. All calls to the model will pass through this class.
 */
public class Controller {
    private ItemRegistry itemRegistry;
    private SystemCreator systemCreator;
    private SaleInformation saleInfo;
    private CashRegistry cashRegistry;
    private Payment payment;
    private List<PaymentObserver> paymentObservers = new ArrayList<>();


    public Controller() {
        systemCreator = new SystemCreator();
        cashRegistry = new CashRegistry();
        payment = new Payment();

    }

    public Controller(SaleInformation sale) {
        systemCreator = new SystemCreator();
        cashRegistry = new CashRegistry();
        payment = new Payment();
        saleInfo = sale;
        paymentObservers=new ArrayList<>();
    }

    public void addPaymentObserver(PaymentObserver paymentObserver) {
        paymentObservers.add(paymentObserver);
        }

    /**
     * starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startNewSale() {
        itemRegistry = new ItemRegistry();
        saleInfo = new SaleInformation();
    }



    /**
     * This method adds the scanned items to the current sale.
     *
     * @param itemId   represents the scanned item's identification number.
     * @param quantity represents the quantity of the scanned item.
     * @return This methods return the item description if the item found in items registry.
     * @throws InvalidItemIdentifierException if the searched item not found in the store.
     */
    public ItemDTO enterNewItem(int itemId, int quantity) throws DatabaseFailureException, InvalidItemIdentifierException {

        try{
            ItemDTO scannedItem = itemRegistry.searchItem(itemId);


        if (scannedItem != null)
        {
            saleInfo.addToBasket(scannedItem, quantity);
            return scannedItem;
        }
        else
        {
            return null;
        }
    }
        catch (NullPointerException exc) {
            throw new InvalidItemIdentifierException(itemId);
        }
    }


    /**
     * Creates an instance of the class receipt to handel receipt request.
     *
     * @return an instance of the receipt class.
     */
    public Receipt receiptRequest(double paid, double change) {
        Receipt receipt = new Receipt(saleInfo, paid, change);
        return receipt;
    }

    /**
     * This method calls the method that will handel payment process. //TODO
     *
     * @param amountPaid The amount that the customer will pay.
     * @return amount change to return to the customer.
     */
    public double payForCurrentSale(double amountPaid) throws OperationFailedException
    {

        double[] payInfo = payment.pay(amountPaid, saleInfo); //0- what my company win, 1- # money to return to the customer
        saleInfo.addPaymentObservers(paymentObservers);
        cashRegistry.addNewAmount(payInfo[0]);
        return payInfo[1];


    }

    /**
     * This method updates the accounting and inventory system after the sale finish.
     */
    public void updateSystemCreater() {
        systemCreator.updateAccountAndInventory(saleInfo);
    }

}
