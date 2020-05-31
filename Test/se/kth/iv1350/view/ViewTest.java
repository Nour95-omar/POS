package se.kth.iv1350.view;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.DatabaseFailureException;
import se.kth.iv1350.integration.InvalidItemIdentifierException;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Receipt;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ViewTest {
    private View view;
    private Controller contr;
    private List<ItemDTO> items = new ArrayList<>();
    private ItemDTO item;


    public ViewTest()
    {
        contr = new Controller();
        view = new View(contr);
    }

    @Before
    public void setUp() throws Exception {

        items.add (new ItemDTO(50,123456,"Powder Milk"));
        items.add(new ItemDTO(99.59,124676,"Cheddar Cheese"));
        items.add(new ItemDTO(23,764676,"Baby Shampoo"));
        items.add(new ItemDTO(35,761676,"Body Lotion"));
        for(int i=0; i<items.size();i++){
            this.item=items.get(i);
        }

    }


    @Test(expected = InvalidItemIdentifierException.class)
    public void runFakeExecutionAndThrowExceptionTest()
    {
        view.startTheSale();
        ItemDTO firstItem = contr.enterNewItem(4568,0);
       //assertEquals(item,firstItem);

    }

   
}