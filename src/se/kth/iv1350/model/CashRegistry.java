package se.kth.iv1350.model;

public class CashRegistry
{
    private double cashInRegistry;


    /**
     * This method increase the amount in the cash registry with the paid amount of the current sale.
      * @param newAmount The amount of current sale that will be adds to the cash register.
     */
    public void addNewAmount(double newAmount){
        this.cashInRegistry = cashInRegistry + newAmount;
    }




}
