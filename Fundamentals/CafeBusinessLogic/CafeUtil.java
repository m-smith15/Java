import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
        //functions are defined here
        public String getStreakGoal( int numWeeks){
            int drinkSum = 0;
            int i = 1;
            while ( i <= numWeeks){
                drinkSum += i;
                i++;
            }
            return "You need " + drinkSum;
        }
    
        public String getOrderTotal(double[] totalPrice){
            double sumTotal = 0;
            for ( int i = 0; i < totalPrice.length; i++ ){
                sumTotal += totalPrice[i];
            }
            // ArrayList<Double> newArray = new ArrayList<Double>();
            // newArray.add(totalPrice[0]);
            // newArray.add(totalPrice[1]);
            // newArray.add(totalPrice[2]);
            // newArray.add(totalPrice[3]);

            return "Total is " + sumTotal;
            }
            
        public void displayMenu(ArrayList<String> menuItems){
            int i = 0;
            for(String item : menuItems){
                System.out.println(i + " " + item);
                i++;
            }
            
        }
        public void addCustomer(ArrayList<String> customers, int i){
            System.out.println("Please enter your name:");
            String userName = System.console().readLine();
            System.out.println("Hello, " + userName);
            System.out.println("There are " + i + " people in front of you");
            customers.add(userName);
        }

    }
