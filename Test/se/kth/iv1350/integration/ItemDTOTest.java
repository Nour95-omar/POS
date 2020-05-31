package se.kth.iv1350.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDTOTest
{
    private ItemDTO item;

    @Before
    public void setUp() throws Exception
    {
        item = new ItemDTO(25, 1455, "Book");
    }


    @Test
    public void getItemIdentifierTest()
    {
        assertEquals(1455, item.getItemIdentifier());
    }

    @Test
    public void getItemPriceTest() {
        assertEquals(25, item.getItemPrice(), 0.0);

    }

    @Test
    public void getItemDescriptionTest() {
        assertEquals("Book", item.getItemDescription());

    }


}