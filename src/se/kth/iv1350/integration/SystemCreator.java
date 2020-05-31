package se.kth.iv1350.integration;
import se.kth.iv1350.model.SaleInformation;

public class SystemCreator
{

    private final AccountingSystem accountingSystem = new AccountingSystem();
    private final InventorySystem inventorySystem = new InventorySystem();

    public SystemCreator(){
        //..
    }

    /**
     * This method update the accounting system and inventory system after the sale finish.
     * @param saleInformation the current sale information.
     */
    public void updateAccountAndInventory(SaleInformation saleInformation)
    {
        accountingSystem.updateAccountingSystem(saleInformation);
        inventorySystem.updateInventorySystem(saleInformation);
    }



}
