package shop;

import java.util.Comparator;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class SortByPrice implements Comparator<Product> {
  @Override
  public int compare(Product product, Product product2) {
    return product.getPrice().compareTo(product2.getPrice());
  }
}
