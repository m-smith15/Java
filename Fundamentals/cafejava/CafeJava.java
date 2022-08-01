public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        //double mochaPrice = 3.5;
        double dripCoffeePrice = 4.0;
        double lattePrice = 5.5;
        double cappuccinoPrice = 6.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)

        //Cindhuri ordered a Coffee
        String result =  (isReadyOrder1)  ? (generalGreeting + customer1 + readyMessage + displayTotalMessage + dripCoffeePrice) : (generalGreeting + customer1 + pendingMessage); 
        System.out.println(result);

        //Sam ordered 2 lattes
        result =  (isReadyOrder2)  ? (generalGreeting + customer2 + readyMessage + displayTotalMessage + (lattePrice * 2)) : (generalGreeting + customer2 + pendingMessage); 
        System.out.println(result);

        //Jimmy - ordered a latte charged a coffee update difference
        result =  (isReadyOrder3)  ? (generalGreeting + customer3 + readyMessage + displayTotalMessage + (lattePrice - dripCoffeePrice)) : (generalGreeting + customer3 + pendingMessage); 
        System.out.println(result);

        //Noah ordered Cappuccino
        result =  (isReadyOrder4)  ? (generalGreeting + customer4 + readyMessage + displayTotalMessage + cappuccinoPrice) : (generalGreeting + customer4 + pendingMessage); 
        System.out.println(result);

        // Example:
        //System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
    }
}
