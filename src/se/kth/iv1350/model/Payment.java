package se.kth.iv1350.model;



import se.kth.iv1350.controller.OperationFailedException;

public class Payment {

    /**
     *
     * @param totalPaid
     * @param saleInfo
     * @return an array of 1- what my company win, 2- how much money to return to the customer
     */ //TODO test the exception here
    public double[] pay(double totalPaid, SaleInformation saleInfo) throws OperationFailedException
    {
        if (saleInfo == null )
            throw new OperationFailedException("saleInfo is not initialized in Payment", new NullPointerException());

        double totalWin = saleInfo.getPriceIncludingTax();
        double change =  amountOfChange(totalPaid, totalWin);
        double[] payInfo = new double[]{totalWin, change};

        return payInfo;

    }


    /**
     * This method calculates the amount change that the customer will get back.
     * @param totalPaid The amount the customer paid.
     * @param totalCost The cost of the purchase.
     * @return
     */
    public double amountOfChange(double totalPaid, double totalCost){
        return totalPaid-totalCost;
    }
}
