package shop;

import java.util.HashMap;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class MyOrderList {

  private HashMap<String,Integer> orderList = new HashMap<String, Integer>();
  public void addLine(String productName, int quantity) {
    orderList.put(productName,quantity);

  }

  public HashMap<String, Integer> getOrderList() {
    return orderList;
  }
}
