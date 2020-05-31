package se.kth.iv1350.controller;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.integration.*;


import static org.junit.Assert.*;

public class ControllerTest {

    private Controller contr;


    @Before
    public void setUp() throws Exception {
        contr = new Controller();

    }


    @Test
    public void TestEnterNewItem() throws DatabaseFailureException, InvalidItemIdentifierException {

        int item = 124676;
        String expected = "This product: " + item + " does not exist in the store";
        try {

            contr.enterNewItem(item, 4);
        } catch (InvalidItemIdentifierException exc) {

            assertNotEquals(expected, exc.getMessage());
        }
    }


    @Test
    public void TestEnterNewFailItem() throws DatabaseFailureException, InvalidItemIdentifierException {

        int item = 124676;
        String expected = "Unfortunately the product:" + item + " does not exist in the store";
        try {

            contr.enterNewItem(item, 4);
        } catch (InvalidItemIdentifierException exc) {

            assertEquals(expected, exc.getMessage());
        }
    }


    @Test
    public void payForCurrentSale() throws OperationFailedException {
        double amountPaid = 500;
        String expectedMsg = "saleInfo is not initialized in Payment";
        try {
            contr.payForCurrentSale(amountPaid);
        } catch (OperationFailedException exc) {
            assertEquals(expectedMsg, exc.getMessage());
        }

    }


}