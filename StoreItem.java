// host: this class is Super class
public abstract class StoreItem {
    // host : define StoreItem attributes
    protected String id, name;
    protected double price;

    // host: Make the Constructor for StoreItem
    StoreItem(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;

    }
        // host : displayInfo used to be next
    public abstract String displayInfo();

    // host: this is getters
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }

}
