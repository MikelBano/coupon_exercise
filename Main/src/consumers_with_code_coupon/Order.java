package consumers_with_code_coupon;

import java.util.ArrayList;
import java.util.List;

public class Order {
private List<String> items;
private  double totalPrice;

  public Order() {
    this.items = new ArrayList<String>();
    this.totalPrice = 0.0;
  }

  public  void addItem(String item, double price){
    items.add(item);
    totalPrice += price;
  }


  public void applyDiscount(Coupon coupon) {

    totalPrice -= totalPrice * (coupon.getDiscountPercentage() / 100);

  }

  public List<String> getItems() {
    return items;
  }

  public double getTotalPrice() {
    return totalPrice;
  }
}
