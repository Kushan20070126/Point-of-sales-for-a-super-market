public class CartItem {
    private  AccSall item;
    private int quantity;

    public CartItem(AccSall item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return item.getDiscountedPrice() * quantity;
    }

    public AccSall getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}