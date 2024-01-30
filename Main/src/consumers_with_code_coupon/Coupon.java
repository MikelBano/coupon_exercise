package consumers_with_code_coupon;

public class Coupon {

    private int number;

    private double discountPercentage;


    public Coupon(int number, double discountPercentage) {

        this.number = number;

        this.discountPercentage = discountPercentage;

    }


    public int getNumber() {

        return number;

    }


    public double getDiscountPercentage() {

        return discountPercentage;

    }

}