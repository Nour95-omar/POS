package se.kth.iv1350.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.integration.ItemDTO;

public class SaleInformation {
    private ArrayList<ItemDTO> scannedItems;
    private ArrayList<Integer> quantityOfEachItem;
    private double totalPriceIncludingTAX;
    private double totalCostWithoutTax;
    private final double TAX = 0.25;
    private List<PaymentObserver> paymentObservers = new ArrayList();

    public SaleInformation()
    {
         scannedItems = new ArrayList<ItemDTO>();
         quantityOfEachItem= new ArrayList<Integer>();
         totalPriceIncludingTAX = 0;
         totalCostWithoutTax = 0;
         paymentObservers=new ArrayList<>();
    }




    private void notifyObservers(){
        for (PaymentObserver obs : paymentObservers) {
            obs.updateTotal(this.totalPriceIncludingTAX);
        }
    }

    /**
     * The specified observers will be notified when a payment is made.
     * @param observers The observers to notify.
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }



    /**
     * Adding new items to the shopping basket.
     * @param newItem a form of item description includes item's name,price and Id.
     */
    public void addToBasket(ItemDTO newItem, int quantity)
    {

            if (scannedItems.isEmpty()) {
                addNewItem(newItem, quantity);
                return;
            }

            int[] itemInfo = isAlreadyExist(newItem);

            if (itemInfo[0] == 1) { //if exist before
                int index = itemInfo[1];
                quantityOfEachItem.set(index, quantityOfEachItem.get(index) + quantity);
                updateTotalCostWithoutTax(newItem, quantity);

            } else {
                addNewItem(newItem, quantity);
            }


    }

    private void addNewItem(ItemDTO newItem, int quantity)
    {
        scannedItems.add(newItem);
        quantityOfEachItem.add(quantity);
        updateTotalCostWithoutTax(newItem, quantity);

    }

    /**
     * TODO
     * compares the new scanned item with the items that already scanned.
     * @param newItem the new scanned item.
     * @return array 1- yes = 1, no =0 item exist, 2-index of this item
     */
    private int[] isAlreadyExist(ItemDTO newItem)
    {
        for (int i = 0; i < scannedItems.size(); i++)
        {
            if (scannedItems.get(i).getItemIdentifier() == newItem.getItemIdentifier())
            {
                return new int[]{1, i};
            }
        }

        return new int[]{0, 0};
    }


    /**
     * This method calculates the cost of the items.
     * @param item The items that has been sold.
     * @param quantity The sold quantity of each item.
     */
    public void updateTotalCostWithoutTax(ItemDTO item, int quantity){

        this.totalCostWithoutTax = totalCostWithoutTax + item.getItemPrice() * quantity;
    }

    /**
     * This method calculates the cost of shop including value of VAT.
     */
    public void updateTotalCostIncludingTax(){

        this.totalPriceIncludingTAX = this.totalCostWithoutTax + (this.totalCostWithoutTax * TAX);

    }


    /**
     * This method gets all the scanned items from the list.
     * @return List of type ItemDTO that represent the scanned items.
     */
    public ArrayList<ItemDTO> getScannedItems(){
        return this.scannedItems;
    }

    /**
     * This method gets the sold quantity of each item.
     * @return the sold quantity of items.
     */
    public ArrayList<Integer> getQuantityOfEachItem(){
        return this.quantityOfEachItem;
    }


    /**
     * gets the total cost of items.
     * @return the total amount of items.
     */
    public double getTotalCostWithoutTax(){

        return this.totalCostWithoutTax;
    }

    /**
     * gets the total cost of items including VAT.
     * @return the total amount of items including VAT.
     */
    public double getPriceIncludingTax(){
        notifyObservers();
        updateTotalCostIncludingTax();
        return this.totalPriceIncludingTAX;

    }

}
