public class CartItem {

    private AccSall item;
    private int quantity;

    // Constructor
    public CartItem(AccSall item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Getters and Setters
    public AccSall getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate subtotal
    public double getSubtotal() {
        return item.getDiscountedPrice() * quantity;
    }


    @Override
    public String toString() {
        return String.format(item.getName() + " x " + getQuantity() + " = " + getSubtotal());
    }
}