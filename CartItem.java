public class CartItem {
    private AccSall item;
    private int qyt;

    public CartItem(AccSall item, int q) {
        this.item = item;
        this.qyt = q;
    }

    public AccSall getItem() {
        return item;
    }
    public int getQyt() {
        return qyt;
    }
    public void setQyt(int q) {
        this.qyt = q;
    }
    public double getSubtotal() {
        return item.getDiscountedPrice() * qyt;
    }

    @Override
    public String toString() {
        return String.format(item.getName() +" x " + getQyt() + " " +" = " + getSubtotal());


    }
}