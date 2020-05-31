package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.ItemDTO;

import static org.junit.Assert.*;

public class PaymentTest
{
    private Payment payment;
    private SaleInformation saleInfo;

    @Before
    public void setUp()
    {
        payment = new Payment();
        saleInfo = new SaleInformation();
        saleInfo.addToBasket(new ItemDTO(30.0, 123, "Book"), 2);
    }


    @Test
    public void testAmountOfChange()
    {
        double totalPaid = 200;
        double actualCost = 100;
        double change = payment.amountOfChange(totalPaid, actualCost);

        assertEquals(change, 100, 0.001);
    }

    @Test
    public void testPay() throws OperationFailedException {
        double[] info = payment.pay(100, saleInfo); //TODO more test

        assertEquals(info[0], 75, 0.001);
        assertEquals(info[1], 25, 0.001);

        //Test2
        SaleInformation saleInfo2 = new SaleInformation();
        info = payment.pay(100, saleInfo2); //TODO more test
        assertEquals(info[0], 0, 0.001);
        assertEquals(info[1], 100, 0.001);


        //Test 3
        info = payment.pay(-100, saleInfo);
        assertEquals(info[0], 75, 0.001);
        assertEquals(info[1], -175, 0.001);




    }
}