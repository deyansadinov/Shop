package shop;

import java.util.HashMap;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Shop3 {

  private final HashMap<String, Integer> slot;
  private HashMap<String, ProductSlot> productHolder = new HashMap<String, ProductSlot>();

  public Shop3(HashMap<String, Integer> slot) {
    this.slot = slot;
  }


  public void add(String name, int quantity) {
    if (quantity > slot.get(name)) {
      throw new NotEnoughQuantityException();
    }
    productHolder.put(name, new ProductSlot(new Product(name), quantity));
  }

  public int sell(String name, int quantity) {
    if (productHolder.size() == 0 || productHolder.get(name) == null) {
      throw new EmptyShopException();
    }
    ProductSlot productSlot = productHolder.get(name);
    return productSlot.sell(quantity);
  }

  public int addQuantity(String productName, int quantity) {
    ProductSlot productSlot = productHolder.get(productName);
    if (productSlot.getCurrentQuantity() + quantity > slot.get(productName)){
      throw new FullStoreException();
    }
    return productSlot.add(quantity);
  }

  private class ProductSlot {

    private final Product product;
    private int currentQuantity;

    private ProductSlot(Product product, int currentQuantity) {
      this.product = product;
      this.currentQuantity = currentQuantity;
    }

    public int getCurrentQuantity() {
      return currentQuantity;
    }

    private int sell(int quantity) {
      if (currentQuantity - quantity < 0) {
        throw new NotEnoughQuantityException();
      }
      return currentQuantity -= quantity;
    }

    private int add(int quantity) {
      return currentQuantity += quantity;
    }
  }
}
