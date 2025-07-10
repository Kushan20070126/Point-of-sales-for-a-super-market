public class Cart {
    private CartItem[] items;
    private int count;

    public Cart() {
        items = new CartItem[10];
        count = 0;
    }

    public void addProduct(AccSall product, int qty) {
        for (int i = 0; i < count; i++) {
            if (items[i].getItem().getId() == product.getId()) {
                items[i].setQyt(items[i].getQyt() + qty);
                return;
            }
        }

        if (count == items.length) {
            CartItem[] newItems = new CartItem[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }

        items[count++] = new CartItem(product, qty);
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < count; i++) {
            if (items[i].getItem().getId().equals(productId)) {
                System.arraycopy(items, i + 1, items, i, count - i - 1);
                items[--count] = null;
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    public void clearCart() {
        items = new CartItem[10];
        count = 0;
    }

    public CartItem[] getItems() {
        CartItem[] result = new CartItem[count];
        System.arraycopy(items, 0, result, 0, count);
        return result;
    }

    public int getCount() {
        return count;
    }
}