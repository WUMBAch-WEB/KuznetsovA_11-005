public class Discount {
    String shopName;
    String buyerName;
    int discount;

    public Discount(String shopName, String buyerName, int discount) {
        this.shopName = shopName;
        this.buyerName = buyerName;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Buyer: " + buyerName + " have discount: " + discount + "in shop: " + shopName;
    }
}
