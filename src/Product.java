public class Product {
    String name;
    double price;
    boolean isPurchased;
    public Product(String name, double price){
        this.name=name;
        this.price=price;
        this.isPurchased=false;
    }
    @Override
    public String toString(){
        return (isPurchased?"[x] ":"[ ]")+name+" -$"+price;

    }
}

