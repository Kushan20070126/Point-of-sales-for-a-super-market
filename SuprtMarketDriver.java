import java.util.Scanner;

public class SuprtMarketDriver {
    private int productCount = 0;
    Product[] pro = new Product[100];
    Cart cat = new Cart();
    Scanner scan = new Scanner(System.in);

    private void initializeInventory() {
        Product p1 =  new Product("P002", "Basmati Rice - 1.00 kg", 140.00, 200);
        Product p2 =  new Product("P001", "Astra Baking, Ambient - 1.00 kg", 250, 100);
        Product p3 =   new Product("P003", "Surf Excel Laundry Detergent Powder, Comfort - 1.00 kg", 3.99, 150);
        Product p4 =  new Product("P004", "Baby Cheramy Moisturising Soap - 90.00 g", 6.99, 100);
        addProduct(p1);
        addProduct(p2);
        addProduct(p3);
        addProduct(p4);
    }

    private void addProduct(Product product) {
        if (productCount < pro.length) {
            pro[productCount++] = product;
        }
    }

    private Product findProduct(String id) {
        for (int i = 0; i < productCount; i++) {
            if (pro[i].getId().equals(id)) {
                return pro[i];
            }
        }
        return null;
    }

    public void start() {
        initializeInventory();
        while (true) {
            System.out.println("=== Point of Sale Supermarket System ===");
            System.out.println("1. Add to Cart");
            System.out.println("2. Remove from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Products");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1: addToCart(); break;
                case 2: removeFromCart(); break;
                case 3: viewCart(); break;
                case 4: checkout(); break;
                case 5: viewProducts(); break;
                default: System.out.println("Invalid option!");
            }
        }
        scan.close();
    }

    private void addToCart() {
        System.out.print("Enter product ID: ");
        String id = scan.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scan.nextInt();

        Product product = findProduct(id);
        if (product != null && product.getStock() >= quantity) {
            cat.addProduct(product, quantity);
            product.updateStock(-quantity);
            System.out.println("Product added to cart!");
        } else {
            System.out.println("Product not found or insufficient stock!");
        }
    }

    private void removeFromCart() {
        System.out.print("Enter product ID to remove: ");
        String id = scan.nextLine();
        cat.removeProduct(id);
        System.out.println("Product removed from cart!");
    }

    private void viewCart() {
        System.out.println("=== Cart Contents ===");
        CartItem[] items = cat.getItems();
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: " + cat.getTotal());
    }

    private void checkout() {
        if (cat.getCount() == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        viewCart();
        System.out.print("Enter payment amount: $");
        double payment = scan.nextDouble();

        if (payment >= cat.getTotal()) {
            System.out.println("Change: "+ (payment - cat.getTotal()));
            cat.clearCart();
            System.out.println("Thank you for your purchase!");
        } else {
            System.out.println("Insufficient payment!");
        }
    }

    private void viewProducts() {
        System.out.println("=== Available Products ===");
        for (int i = 0; i < productCount; i++) {
            System.out.println(pro[i]);
        }
    }

    public static void main(String[] args) {
        SuprtMarketDriver pos = new SuprtMarketDriver();
        pos.start();
    }
}