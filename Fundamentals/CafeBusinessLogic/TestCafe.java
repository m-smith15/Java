import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        
    /* 
    You will need add 1 line to this file to create an instance 
    of the CafeUtil class. 
    Hint: it will need to correspond with the variable name used below..
    */
        // Make an instance of cafeBusinessLogic to access all its methods.
        CafeUtil cafeBusinessLogic = new CafeUtil();
    
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        int numWeeks = 11;
        System.out.printf("Purchases needed by week " +numWeeks+ ": %s \n\n", cafeBusinessLogic.getStreakGoal(numWeeks));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        //ArrayList<Double> totalPrice = (double) lineItems;
        System.out.printf("Order total: %s \n\n",cafeBusinessLogic.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        cafeBusinessLogic.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafeBusinessLogic.addCustomer(customers, i);
            System.out.println("\n");
        }
        System.out.println(customers);
    }
}
