import java.util.Scanner;

public class SuprtMarketDriver {
    private Product[] inventory;
    private Cart cart;
    private Scanner scanner;
    private int productCount;

    public SuprtMarketDriver() {
        inventory = new Product[100];
        cart = new Cart();
        scanner = new Scanner(System.in);
        productCount = 0;
        initializeInventory();
    }

    private void initializeInventory() {
        addProduct(new Product("P001", "Rice", 25.99, 100));
        addProduct(new Product("P002", "Milk", 4.99, 200));
        addProduct(new Product("P003", "Bread", 3.99, 150));
        addProduct(new Product("P004", "Eggs", 6.99, 100));
    }

    private void addProduct(Product product) {
        if (productCount < inventory.length) {
            inventory[productCount++] = product;
        }
    }

    private Product findProduct(String id) {
        for (int i = 0; i < productCount; i++) {
            if (inventory[i].getId().equals(id)) {
                return inventory[i];
            }
        }
        return null;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== POS System ===");
            System.out.println("1. Add to Cart");
            System.out.println("2. Remove from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Products");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addToCart(); break;
                case 2: removeFromCart(); break;
                case 3: viewCart(); break;
                case 4: checkout(); break;
                case 5: viewProducts(); break;
                case 6: return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private void addToCart() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Product product = findProduct(id);
        if (product != null && product.getStock() >= quantity) {
            cart.addProduct(product, quantity);
            product.updateStock(-quantity);
            System.out.println("Product added to cart!");
        } else {
            System.out.println("Product not found or insufficient stock!");
        }
    }

    private void removeFromCart() {
        System.out.print("Enter product ID to remove: ");
        String id = scanner.nextLine();
        cart.removeProduct(id);
        System.out.println("Product removed from cart!");
    }

    private void viewCart() {
        System.out.println("\n=== Cart Contents ===");
        CartItem[] items = cart.getItems();
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.printf("Total: $%.2f%n", cart.getTotal());
    }

    private void checkout() {
        if (cart.getCount() == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        viewCart();
        System.out.print("Enter payment amount: $");
        double payment = scanner.nextDouble();

        if (payment >= cart.getTotal()) {
            System.out.printf("Change: $%.2f%n", payment - cart.getTotal());
            cart.clearCart();
            System.out.println("Thank you for your purchase!");
        } else {
            System.out.println("Insufficient payment!");
        }
    }

    private void viewProducts() {
        System.out.println("\n=== Available Products ===");
        for (int i = 0; i < productCount; i++) {
            System.out.println(inventory[i]);
        }
    }

    public static void main(String[] args) {
        SuprtMarketDriver pos = new SuprtMarketDriver();
        pos.start();
    }
}
