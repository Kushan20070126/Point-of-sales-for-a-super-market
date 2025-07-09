public class Product {
    private String id;
    private String name;
    private double price;
    private int stockQyt;

    public Product(String id, String n, double p, int sq) {
        this.id = id;
        this.name = n;
        this.price = p;
        this.stockQyt = sq;
    }
    // Getters and setters
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStockQyt(){
        return stockQyt;
    }

    public void adjustStock(int amount) {
        this.stockQyt += amount;
    }

    // ... other methods
}