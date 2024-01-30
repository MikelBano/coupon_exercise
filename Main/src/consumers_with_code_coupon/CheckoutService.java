package consumers_with_code_coupon;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class CheckoutService {

  private Consumer<Order> processOrder;

  private BiConsumer<Order, Coupon> applyDiscount;


  public CheckoutService(Consumer<Order> processOrder, BiConsumer<Order, Coupon> applyDiscount) {

    this.processOrder = processOrder;

    this.applyDiscount = applyDiscount;

  }


  public void checkout(Order o, Coupon coupon) {

    if (coupon != null) {

      applyDiscount.accept(o, coupon);

    }


    processOrder.accept(o);

  }

}
