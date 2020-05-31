package se.kth.iv1350.integration;
import se.kth.iv1350.integration.ItemDTO;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ItemRegistryTest {
    private ItemRegistry itemRegistry;
    private  ItemDTO itemDTO;
    private List<ItemDTO> items = new ArrayList<>();
    ItemDTO item=new ItemDTO (20,135987,"milk");




    @Before
    public void setUp()
    {
     itemRegistry=new ItemRegistry();

    }



    @Test
    public void testItemNotFound() throws InvalidItemIdentifierException{
        int itemToBeTested=1234680;
      String  expectedMessage=("Unfortunately the product:"+itemToBeTested+ " does not exist in the store");


       try{
           itemRegistry.searchItem(itemToBeTested);
       }
       catch (InvalidItemIdentifierException exc){
           assertEquals(expectedMessage, exc.getMessage());

       }
    }
/*
    @Test
    public void testEmptyItemRegistry() throws DatabaseFailureException{
        List<ItemDTO> items = new ArrayList<>();
        String unexpectedMessage=("k;;");

        try {
            itemRegistry.addItems();
                items.add(new ItemDTO(50, 123456, "Powder Milk"));

        }
        catch (DatabaseFailureException exc){
            assertNotEquals(unexpectedMessage,exc.getMessage());
        }
    }*/




    @Test
    public void searchItemTest() {
        int newItem=135987;
        ItemDTO checkedItem= itemRegistry.searchItem(newItem);
        assertEquals(item.getItemIdentifier(),checkedItem.getItemIdentifier());
    }

    @Test
    public void addItemsTest() {
        assertNotNull("The arrayList items contains an item", items);

    }
}