public class Cart {
    private CartItem[] items;
    private int itemCount;
    private static final int MAX_ITEMS = 100;

    public Cart() {
        items = new CartItem[MAX_ITEMS];
        itemCount = 0;
    }

    public void addProduct(AccSall product, int quantity) {
        if (itemCount >= MAX_ITEMS) {
            throw new IllegalStateException("Cart is full");
        }

        for (int i = 0; i < itemCount; i++) {
            if (items[i].getItem().getId().equals(product.getId())) {
                items[i].setQuantity(items[i].getQuantity() + quantity);
                return;
            }
        }

        items[itemCount++] = new CartItem(product, quantity);
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getItem().getId().equals(productId)) {
                // Shift remaining elements left
                System.arraycopy(items, i + 1, items, i, itemCount - i - 1);
                items[--itemCount] = null;
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    public void clearCart() {
        items = new CartItem[MAX_ITEMS];
        itemCount = 0;
    }

    public CartItem[] getItems() {
        CartItem[] result = new CartItem[itemCount];
        System.arraycopy(items, 0, result, 0, itemCount);
        return result;
    }

    public int getItemCount() {
        return itemCount;
    }
}