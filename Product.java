// Product class
public class Product implements AccSall {
    private String id;
    private String name;
    private double price;
    private int stock;

    // Constructor
    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //getters override
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getedPrice() {
        return price;  // No discount for regular products
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Price: (RS)" + price + ", Stock: " + stock;
    }

}