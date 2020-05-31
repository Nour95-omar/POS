package se.kth.iv1350.integration;

/**
 * contains information about one particular item.
 */
public final class ItemDTO {
    private final double price;
    private final int itemIdentifier;
    private final String itemDescription;


    /**
     * creats a new instance representing a particular item.
     * @param price represents the price of scanned item
     * @param itemIdentifier represents the item identifier.
     * @param itemDescription represents the item name and description.
     */
    public ItemDTO(double price,int itemIdentifier, String itemDescription){
        this.itemIdentifier=itemIdentifier;
        this.price=price;
        this.itemDescription=itemDescription;

    }


    public int getItemIdentifier(){
        return itemIdentifier;
    }
    public double getItemPrice(){
        return price;
    }
    public String getItemDescription(){
        return itemDescription;
    }


    @Override
    public String toString()
    {
        return itemDescription + " ID: " + itemIdentifier + " price: " + price + " kr.";
    }

}
