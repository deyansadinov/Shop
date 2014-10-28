package shop;

import java.util.HashMap;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Shop2 {

  private HashMap<String, ProductSlot> productHolder = new HashMap<String, ProductSlot>();



  public int sell(String name, int quantity) {
    if (productHolder.size() == 0 || productHolder.get(name) == null) {
      throw new EmptyShopException();
    }

    ProductSlot productSlot = productHolder.get(name);
    return productSlot.sell(quantity);
  }

  public void addProduct(Product product, int currentQuantity) {
    productHolder.put(product.getName(), new ProductSlot(currentQuantity));

  }

  public int addQuantity(String name, int quantity) {
    ProductSlot productSlot = productHolder.get(name);
    return  productSlot.add(quantity);
  }


  private class ProductSlot {

    private int currentQuantity;

    private ProductSlot(int currentQuantity) {
      this.currentQuantity = currentQuantity;

    }

    public int sell(int quantity) {
      if (currentQuantity - quantity < 0)
      {
        throw new NotEnoughQuantityException();
      }
      return currentQuantity -= quantity;
    }

    public int add(int quantity) {
      return currentQuantity += quantity;
    }
  }


}
