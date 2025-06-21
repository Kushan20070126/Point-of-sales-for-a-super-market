import java.util.SplittableRandom;

// host: i made this Product sub class in to the StoreItem super class
public class Product extends StoreItem {

    // host : define Product attributes
    private int qytInStock;
    private String category;

    // host: Make the Constructor for Product
    Product(String id, String name , double price , int qyt, String cat){
        super(id,name,price); // call super class StoreItem
        this.qytInStock = qyt;
        this.category = cat;

    }

    // host : Implement displayInfo method
    @Override
    public String displayInfo(){
        return String.format("[%s] %s ($%.2f | Qty: %d)",
                id, name, price, qytInStock);
    }

    // host: making updateStock add more items qyt
    public void updateStock(int qyt){

        this.qytInStock += qyt;
    }






}
