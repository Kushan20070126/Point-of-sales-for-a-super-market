// Cart class
public class Cart {

    private CartItem[] items;
    private int count;



    // Constructor - creates an empty cart
    public Cart() {
        this.items = new CartItem[10];
        this.count = 0;
    }

    // Add a product to cart
    public void addProduct(AccSall product, int quantity) {
        // Check if product already in cart
        for (int i = 0; i < count; i++) {

            if (items[i].getItem().getId() == product.getId()) {

                // Update quantity
                items[i].setQuantity(items[i].getQuantity() + quantity);

                return;
            }
        }

        // Check cart is full
        if (count >= 10) {

            System.out.println("Cart is full!");

            return;
        }

        // Add new item to cart
        items[count] = new CartItem(product, quantity);

        count++;
    }

    // Remove a product from cart
    public void removeProduct(String productId) {

        for (int i = 0; i < count; i++) {

            if (items[i].getItem().getId().equals(productId)) {

                items[i] = items[count - 1];

                items[count - 1] = null;
                count--;


                return;
            }
        }
    }

    // Calculate total price
    public double getTotal() {

        double total = 0;

        for (int i = 0; i < count; i++) {

            total += items[i].getSubtotal();
        }
        return total;


    }

    // Clear all items from cart
    public void clearCart() {

        items = new CartItem[10];
        count = 0;
    }

    // Get all items in cart
    public CartItem[] getItems() {

        CartItem[] result = new CartItem[count];

        for (int i = 0; i < count; i++) {

            result[i] = items[i];

        }
        return result;
    }

    public int getCount() {
        return count;
    }
}