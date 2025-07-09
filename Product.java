public abstract class Product implements AccSall {
    private String id;
    private String name;
    private double price;
    private int stockQyt;


    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQyt = stockQuantity;

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

    public int getStockyt() {
        return stockQyt;
    }

    public void adjustStock(int newStock) {
        this.stockQyt += newStock;
    }

}