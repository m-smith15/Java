import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.addItem("Mocha", 5.50);
        System.out.println(item1.name + " " + item1.price);

        Item item2 = new Item();
        item2.addItem("Latte", 7.50);
        System.out.println(item2.name + " " + item2.price);

        Item item3 = new Item();
        item3.addItem("Drip Coffee", 9.50);
        System.out.println(item3.name + " " + item3.price);

        Item item4 = new Item();
        item4.addItem("Capuccino", 6.50);
        System.out.println(item4.name + " " + item4.price);

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        System.out.println(order1.name);
        //print order1.total will have null results
        System.out.println(order1.total);
        order1.ready = true;

        Order order2 = new Order();
        order2.name = "Jimmy";
        System.out.println(order2.name);
        order2.items.add(item1);
        System.out.println(order2.items);
        order2.total += item1.price;
        System.out.println(order2.total);
        order2.ready = true;

        Order order3 = new Order();
        order3.name = "Noah";
        System.out.println(order3.name);
        order3.total = item4.price;
        System.out.println(order3.total);
        order3.items.add(item4);
        //flexing on the haters 
        //trying to pull the name of the ArrayList<Item>
        System.out.println(order3.items.get(0).name);

        Order order4 = new Order();
        order4.name = "Sam";
        System.out.println(order4.name);
        order4.items.add(item2);
        System.out.println(order4.items);
        order4.items.add(item2);
        order4.items.add(item2);
        System.out.println(order4.items);

        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
        
        // System.out.println(item1.name);
        // System.out.println(item2.name + " " + item2.price);
        // System.out.println(item3.name + " " + item3.price);
        // System.out.println(item4.name);
    }
}
