// host: i made this Service sub class in to the StoreItem super class
class Service extends StoreItem {
    // host : define Service attributes
    private int durationMinutes;


    // host: Make the Constructor for Service
     public Service(String id, String name, double price, int duration) {
        super(id, name, price);
        this.durationMinutes = duration;
    }

    @Override
    // host : Implement displayInfo method
    public String displayInfo() {
        return String.format("[%s] %s ($%.2f | %d mins)",
                id, name, price, durationMinutes);
    }
}