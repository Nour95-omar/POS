package se.kth.iv1350.integration;

/**
 * This class representing the unchecked exception InvalidItemIdentifierException which thrown when the item does not exist in the store.
 */
public class InvalidItemIdentifierException extends RuntimeException {
    private int invalidItem;

    /**
     * This method creates an instance of the InvalidItemIdentifierException which throws if the scanned item is invalid.
     * @param itemId Represents the item identifier for the scanned item.
     */
    public InvalidItemIdentifierException(int itemId){
        super("Unfortunately the product:"+itemId+" does not exist in the store");
        this.invalidItem=itemId;
    }

    /**
     * This method gets the itemId that does not exist in the store.
     * @return The item identifier number for the item that does not exist in the store.
     */
    public int getInvalidItem(){
        return this.invalidItem;
    }
}
