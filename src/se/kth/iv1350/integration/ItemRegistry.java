package se.kth.iv1350.integration;
import se.kth.iv1350.controller.OperationFailedException;

import javax.management.OperationsException;
import javax.management.openmbean.OpenDataException;
import java.util.ArrayList;
import java.util.List;

/**
 * contains all calls to the data store with items that may be scanned.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList<>();

    public ItemRegistry()
    {
        this.items=items;
        addItems();
    }


    /**
     * This method adds new items to the registry system.
     * throws DatabaseFailurException if the item registry is empty.
     */
    public void addItems() {
        if ((items == null)){
            throw new DatabaseFailureException("The database can not be called\n");
        }
      items.add(new ItemDTO(50,123456,"Powder Milk"));
      items.add(new ItemDTO(99.59,124676,"Cheddar Cheese"));
      items.add(new ItemDTO(23,764676,"Baby Shampoo"));
      items.add(new ItemDTO(35,761676,"Body Lotion"));
      items.add(new ItemDTO(15.90,324676,"Washing Powder"));
      items.add(new ItemDTO (20,135987,"milk"));

    }


    /**
     * Search for an item matching the specified scanned identifier.
     * @param itemId This object represents the scanned item's identification.
     * @return the itemDTO if the item exists in the registry, otherwise returns null.
     * @throws InvalidItemIdentifierException if the searched item identifier does not exist in the store.
     * @throws DatabaseFailureException if the database could not be reached.
     */
    public ItemDTO searchItem (int itemId) throws InvalidItemIdentifierException,DatabaseFailureException {
          for (ItemDTO itemDTO : items)
          {
              if (itemDTO.getItemIdentifier() == itemId) {
                  return itemDTO;
              }

          }

         throw new InvalidItemIdentifierException(itemId);


    }



}
