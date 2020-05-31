package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.integration.ItemDTO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SaleInformationTest {
    private SaleInformation saleInformation;
    ItemDTO item=new ItemDTO (20,135987,"milk");
    ItemDTO itemToBTested=new ItemDTO (44.50,129784,"Fish");
    int quantity=2;
    private double totalPriceIncludingTAX;
    private double totalCostWithoutTax;
    private final double TAX = 0.25;


    @Before
    public void setUp() throws Exception {
        saleInformation=new SaleInformation();
    }


    @Test
    public void addToBasketTest() {
    }

    @Test
    public void updateTotalCostWithoutTaxTest() {
        this.totalCostWithoutTax = totalCostWithoutTax + item.getItemPrice() * quantity;
        assertEquals(40,totalCostWithoutTax,0.001);

    }

    @Test
    public void updateTotalCostWithoutTestingWrongAmount() {
        this.totalCostWithoutTax = totalCostWithoutTax + item.getItemPrice() * quantity;
        assertNotEquals(35.90,totalCostWithoutTax,0.001);

    }

    @Test
    public void priceIncludingTaxTest() {
        this.totalCostWithoutTax=40;
        this.totalPriceIncludingTAX = this.totalCostWithoutTax + (this.totalCostWithoutTax * TAX);
        assertEquals(50,totalPriceIncludingTAX,0.001);
    }

    @Test
    public void priceIncludingTestingWrongAmount() {
        this.totalCostWithoutTax=40;
        this.totalPriceIncludingTAX = this.totalCostWithoutTax + (this.totalCostWithoutTax * TAX);
        assertNotEquals(60.85,totalPriceIncludingTAX,0.001);
    }


}