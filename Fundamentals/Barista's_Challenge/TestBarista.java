import java.util.ArrayList;
import java.util.Arrays;

public class TestBarista {

    public static void main(String[] args) {
        

        //Create 2 orders for unspecified guests (no name)
        Order order1 = new Order();
        System.out.println(order1.getName());
        Order order2 = new Order();
        System.out.println(order2.getName());
        //Create 3 orders using overload to give name
        Order nameOrder1 = new Order("Shrimp");
        System.out.println(nameOrder1.getName());
        Order nameOrder2 = new Order("Lobster");
        System.out.println(nameOrder2.getName());
        Order nameOrder3 = new Order("Orca");
        System.out.println(nameOrder3.getName());

        //create example items
        Item item1 = new Item("Latte", 10.0);
        Item item2 = new Item("Irish Coffee", 15.0);

        //add at least 2 items to each of the orders
        //executive decision that I'm only going to add to named orders

        //using getOrderTotal() in display, saving a few lines by removing and using display();
        nameOrder1.addItem(item1);
        nameOrder1.addItem(item1);
        nameOrder1.setReady(true);
        System.out.println(nameOrder1.getStatusMessage());
        nameOrder1.display();

        nameOrder2.addItem(item1);
        nameOrder2.addItem(item2);
        System.out.println(nameOrder2.getStatusMessage());
        nameOrder2.display();

        nameOrder3.addItem(item2);
        nameOrder3.addItem(item2);
        nameOrder3.setReady(false);
        System.out.println(nameOrder3.getStatusMessage());
        nameOrder3.display();


        //testing/debugging
        // Item itemExample = new Item("Mocha", 12.0);
        // Order orderExample = new Order();
        // System.out.println(orderExample.getName());
        // System.out.println(orderExample.isReady());
        // orderExample.addItem(itemExample);
        // orderExample.addItem(itemExample);
        // System.out.println(orderExample.getItems());
        // System.out.println(orderExample.getStatusMessage());
        // orderExample.setReady(true);
        // System.out.println(orderExample.getStatusMessage());
        // System.out.println(orderExample.getOrderTotal());
        // orderExample.display();
    }
}
