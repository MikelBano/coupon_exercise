package consumers_with_code_coupon;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerCodeCoupon {
  public static void main(String[] args) {
    Scanner Scannerinput = new Scanner(System.in);
    Order productorderlist = new Order();

    Consumer<Order> processOrder = o -> System.out.println(
            "Order processed. Total: $" +
                    String.format(
                            "%.2f", o.getTotalPrice()
                    )
    );

    BiConsumer<Order, Coupon> applyDiscount = (o, d) -> {
      o.applyDiscount(d);
      System.out.println("Discount of " + d.getDiscountPercentage() + "% applied. New total: $" + String.format("%.2f", o.getTotalPrice()));
    };

    CheckoutService checkoutService = new CheckoutService(processOrder, applyDiscount);

    System.out.println("Welcome to best seller store!");

    String action;

    do {
      System.out.println("Choose an action: [add] item, [checkout], or [exit]");
      action = Scannerinput.nextLine();
      switch (action.toLowerCase()){
        case "add":
          System.out.println("Enter product name:");
          String product = Scannerinput.nextLine();
          System.out.println("Enter product price :");
          //double price = input.nextDouble();
          double price = Double.parseDouble(Scannerinput.nextLine());
          productorderlist.addItem(product, price);
          System.out.println( product + " added successfully to order List.");
          break;

        case "checkout":

          System.out.println("Enter the coupon number:");

          int couponNumber = Integer.parseInt(Scannerinput.nextLine());

          Coupon coupon = null;

          if (couponNumber == 1111) {

            coupon = new Coupon(1111, 10);

          } else if (couponNumber == 2222) {

            coupon = new Coupon(2222, 20);

          } else if (couponNumber == 3333) {

            coupon = new Coupon(3333, 30);

          } else if (couponNumber == 4444) {

            coupon = new Coupon(4444, 40);

          }else System.out.println(couponNumber + " this is not a valid coupon number!! please enter a valid coupon number and try again or no discount will be activated to your chosen product!");

          checkoutService.checkout(productorderlist, coupon);

          productorderlist = new Order(); // Reset the order for the next customer

          break;


        case "exit":

          System.out.println("Thank you for visiting us! hope to see you soon again!");

          break;


        default:

          System.out.println("Invalid action. Please try again.");

          break; // not required -- optional

      }

    } while (!action.equalsIgnoreCase("exit"));


    Scannerinput.close();


  }

}



