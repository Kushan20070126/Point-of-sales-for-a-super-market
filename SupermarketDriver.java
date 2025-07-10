import java.util.Scanner;

//main drive ea
public class SupermarketDriver {
    private Product[] inventory;
    private int productCount;
    private Cart cart;
    private Scanner scanner;


    // Constructor
    public SupermarketDriver() {

        this.inventory = new Product[100];
        this.productCount = 0;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
        addingInventory();
    }

    // add sample inventory
    private void addingInventory() {
        Product p1 = new Product("P001", "Rice 1kg", 140.00, 200);
        Product p2 = new Product("P002", "Book CR Page 120", 250.00, 100);
        Product p3 = new Product("P003", "Milk 1L", 120.00, 150);
        Product p4 = new Product("P004", "Eggs", 180.00, 100);

        addProduct(p1);
        addProduct(p2);
        addProduct(p3);
        addProduct(p4);
    }

    // Add product to inventory
    private void addProduct(Product product) {


        if (productCount < 100) {

            inventory[productCount++] = product;
        }
    }

    // Find product by ID
    private Product findProduct(String id) {


        for (int i = 0; i < productCount; i++) {


            if (inventory[i].getId().equals(id)) {


                return inventory[i];
            }
        }
        return null;
    }

    // Main menu
    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); //new error ekkak

            switch (choice) {
                case 1: addToCart();
                break;
                case 2: removeFromCart();
                break;
                case 3: viewCart();
                break;
                case 4: checkout();
                break;
                case 5: viewProducts();
                break;
                case 6: running = false;
                break;
                default: System.out.println("Invalid choice!");
            }
            System.out.println("**********************************************************");
        }
    }

    // Display main menu
    private void displayMenu() {

        System.out.println("                WELCOME              ");
        System.out.println("******* Supermarket Management System ********");

        System.out.println("1. Add to Cart");

        System.out.println("2. Remove from Cart");

        System.out.println("3. View Cart");

        System.out.println("4. Checkout");

        System.out.println("5. View Products");

        System.out.println("6. Exit");

        System.out.print("Choose option: ");
    }

    // Add product to cart
    private void addToCart() {
        //ui ID
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        //ui qyt
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Product product = findProduct(id);

        if (product != null && product.getStock() >= quantity) {

            cart.addProduct(product, quantity);

            product.updateStock(-quantity);

            System.out.println("Product added to cart!");
            System.out.println("**********************************************************");


        } else {

            System.out.println("Product not found or it not in stock!");
            System.out.println("**********************************************************");

        }
    }

    // Remove product  cart
    private void removeFromCart() {

        System.out.print("Enter product ID to remove: ");
        String id = scanner.nextLine();

        cart.removeProduct(id);
        System.out.println("Product removed from cart!");
    }

    // View cart
    private void viewCart() {
        System.out.println("****** Cart Contents *******");

        CartItem[] items = cart.getItems();

        for (CartItem item : items) {

            System.out.println(item);

        }
        System.out.printf("Total: "+ cart.getTotal());
        System.out.println(" ");
        System.out.println("**********************************************************");

    }

    // Process checkout
    private void checkout() {

        if (cart.getCount() == 0) {

            System.out.println("Cart is empty!");
            System.out.println("**********************************************************");


            return;
        }

        viewCart();

        System.out.print("Enter payment amount: (RS) ");
        double payment = scanner.nextDouble();

        if (payment >= cart.getTotal()) {

            System.out.println("Change: " + (payment - cart.getTotal()));
            cart.clearCart();

            System.out.println("Thank you for your purchase!");
            System.out.println("**********************************************************");


        } else {

            System.out.println("You can't make a payment.!");
            System.out.println("**********************************************************");


        }
    }

    // View available products
    private void viewProducts() {
        System.out.println("******** Available Products ********");

        for (int i = 0; i < productCount; i++) {

            System.out.println(inventory[i]);
            
        }
    }

    // Main method
    public static void main(String[] args) {

       SupermarketDriver sp1 = new SupermarketDriver();

       sp1.start();
    }
}