package shop;

import java.util.HashMap;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Shop {

  private HashMap<String,ProductSlot> productHolder = new HashMap<String, ProductSlot>();

  public int sell(String name, int quanity) {
    if (productHolder.size() == 0 ) {
      throw new EmptyShopException();
    }
    if (productHolder.get(name) == null){
      throw new EmptyShopException();
    }
    ProductSlot productSlot = productHolder.get(name);
    return productSlot.sell(quanity);

  }

  public void addProduct(Product product,int currentQuantity,int maxQuantity) {
    productHolder.put(product.getName(),new ProductSlot(currentQuantity,maxQuantity));
  }

  public int addQuantity(String name, int quantity) {
    ProductSlot productSlot = productHolder.get(name);
    return productSlot.add(quantity);
  }

  private class ProductSlot {
    private int currentQuantity;
    private int maxQuantity;

    private ProductSlot(int currentQuantity,int maxQuantity) {
      this.currentQuantity = currentQuantity;
      this.maxQuantity = maxQuantity;
    }

    public int sell(int quantity) {
      if (currentQuantity - quantity <0){
        throw new NotEnoughQuantityException();
      }
      return currentQuantity -= quantity;
    }

    public int add(int quantity) {
      if (currentQuantity + quantity > maxQuantity){
        throw  new NotEnoughQuantityException();
      }
      return currentQuantity +=quantity;
    }
  }
}
