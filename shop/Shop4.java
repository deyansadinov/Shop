package shop;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Shop4 {
  private final Map<String, Integer> slot;
  private Map<String,ProductSlot> productHolder = new HashMap<String, ProductSlot>();

  public Shop4(Map<String, Integer> slot) {

    this.slot = slot;
  }


  public void addProduct(String productName, int quantity) {
    if (quantity > slot.get(productName)){
      throw new FullStoreException();
    }
    productHolder.put(productName,new ProductSlot(quantity));
  }

  public int sell(String productName, int quantity) {
    if (productHolder.get(productName) == null){
      throw new EmptyShopException();
    }
    ProductSlot productSlot = productHolder.get(productName);
    return productSlot.sell(quantity);
  }

  private class ProductSlot {
    private int currentQuantity;

    private ProductSlot(int currentQuantity) {
      this.currentQuantity = currentQuantity;
    }

    public int sell(int quantity) {
      if (currentQuantity - quantity < 0){
        throw new NotEnoughQuantityException();
      }
      return currentQuantity -= quantity;
    }
  }
}
