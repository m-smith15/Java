import java.util.ArrayList;

public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    //constructor
    public Order(){
        this.name = "Guest";
        this.ready = false;
    }

    //overloaded constructor
    public Order(String name){
        this.name = name;
        this.ready = false;
    }

    //order methods
    public void addItem(Item Item){
        this.items.add(Item);
    }

    public String getStatusMessage(){
        if(this.ready == false){
            return "Thanks fer waitin yer order be up soon";
        }
        else{
            return "Yeehaw order up";
        }
    }
    public double getOrderTotal(){
        double sum = 0;
        for(Item i : this.items){
            sum += i.getPrice();
        }
        return sum;
    }
    public void display(){
        System.out.println("Customer name: " + this.getName());
        for(Item i : this.items){
            System.out.println(i.getName() + " " + i.getPrice());
        }
        System.out.println("Total:" + this.getOrderTotal());
    }

    //getters
    public String getName(){
        return this.name;
    }
    public boolean isReady(){
        return this.ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
}
