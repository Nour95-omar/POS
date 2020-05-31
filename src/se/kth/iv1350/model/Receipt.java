package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents one receipt that proves the payment and sale information ofone sale.
 * @author nourbshar
 *
 */
public class Receipt
{
    private SaleInformation saleInfo;

    private double totalPriceWithoutTAX;
    private double totalPriceIncludingTAX;
    private ArrayList<ItemDTO> soldItems; //TODO
    private ArrayList<Integer> quantityOfEachItem; //TODO


    private String storeName;
    private String address;
    private Date date;

    private double paid;
    private double change;


    /**
     * Creates instance of the class receipt that contains the sale information.
     * @param saleInformation Information about the sale that the receipt will prove.
     */
    public Receipt(SaleInformation saleInformation, double paid, double change){
        saleInfo = saleInformation;

        this.storeName = "Your Market";
        this.address = "Torsplan";
        this.date = new Date();

        this.soldItems = saleInfo.getScannedItems();
        this.quantityOfEachItem = saleInfo.getQuantityOfEachItem();

        this.totalPriceWithoutTAX = saleInfo.getTotalCostWithoutTax();
        this.totalPriceIncludingTAX = saleInfo.getPriceIncludingTax();

        this.paid = paid;
        this.change = change;

    }

    /**
     * @return Gets the total amount before VAT.
     */
    public double getTotalPriceWithoutTAX(){
        return totalPriceWithoutTAX;
    }
    /**
     * @return Gets the total amount including VAT.
     */
    public double getTotalPriceIncludingTAX(){
        return totalPriceIncludingTAX;
    }

    /**
     *
     * @return The name of the store.
     */
    public String getStoreName(){
        return storeName;
    }

    /**
     * @return The store address.
     */
    public String getAddress(){
        return address;
    }
    /**
     * @return Time of sale.
     */
    public Date getDateTimeOfSale(){
        return date;
    }

    public ArrayList<ItemDTO> getSoldItems(){
        return soldItems;
    }

    public ArrayList<Integer> getQuantityOfEachItem(){
        return quantityOfEachItem;
    }



    /**
     * Represents the printed format of the receipt.
     * @return The receipt in form of a <code>String<code/>.
     */
    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append("****************************************\n");
        builder.append("               RECEIPT\n\n");
        builder.append("             " + getStoreName() + "\n\n");
        builder.append("               "+getAddress() + "\n\n");
        builder.append(getDateTimeOfSale() + "\n\n");
        builder.append("****************************************\n");


        builder.append("Included items: \n\n");

        ItemDTO item;
        for(int i = 0; i < soldItems.size(); i++)
        {
            item = soldItems.get(i);
            builder.append(item + ", ");
            builder.append("Quantity: " + quantityOfEachItem.get(i) + "\n\n");
        }

        builder.append("Total Price: " + totalPriceWithoutTAX + " kr \n");
        builder.append("Total Price include VAT-amount: " + totalPriceIncludingTAX + " kr \n");

        builder.append("Amount paid: " + paid + " kr \n");
        builder.append("Change: " + change + " kr\n\n");
        builder.append("****************************************\n");

        return builder.toString();
    }

}
