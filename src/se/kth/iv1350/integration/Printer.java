package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;

/**
 * Prints out a receipt for the target Sale.
 */
public class Printer {

    /**
     * Prints receipt for the current sale.
     * @param receipt contains the sale information the will be presented on the receipt.
     */
    public static void printReceipt(Receipt receipt)
    {
        System.out.println(receipt);
    }



}

