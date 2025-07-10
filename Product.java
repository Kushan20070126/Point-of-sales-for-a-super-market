public class Product implements AccSall {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

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
    public double getDiscountedPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int qyt) {
        this.stock += qyt;
    }

    @Override
    public String toString() {
        return String.format("ID:" + getId() + ", " + " Name: "+getName()+", " + " Price: "+getPrice()+", " + "Stock:" + getStock());
    }
}