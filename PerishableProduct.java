public class PerishableProduct extends Product {
    private String expiryDate;
    private double discountRate;

    public PerishableProduct(String id, String name, double price, int sq, String exDate, double disc) {
        super(id, name, price, sq);
        this.expiryDate = exDate;
        this.discountRate = disc;
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * (1 - discountRate);
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}