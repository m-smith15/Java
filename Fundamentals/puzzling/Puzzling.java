import java.util.ArrayList;
import java.util.Random;

public class Puzzling {
    
    public static ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> randoRoll = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            Random rand = new Random();
            int randNum = rand.nextInt();
            randoRoll.add(randNum);
            //System.out.println(randNum);
        }
        return randoRoll;
    }
    public static char getRandomLetter(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random num = new Random();
        int pickChar = num.nextInt(27);
        return alphabet[pickChar];
    }
    // public static String getRandomPassword(){
    //     char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    //     String resultString = alphabet[];
    //     System.out.println(resultString);
    //     for(int i = 0; i < 8; i++){
    //         Random num = new Random();
    //         int pickChar = num.nextInt(27);
    //         resultString.append(alphabet[pickChar]);
    //     }
    //     return resultString;
    // }

    public static StringBuilder getRandomPassword(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder resultString = new StringBuilder();
        for(int i = 0; i < 8; i++){
            Random num = new Random();
            int pickChar = num.nextInt(27);
            resultString.append(alphabet[pickChar]);
        }
        return resultString;
    }

    public static ArrayList<String> getNewPasswordSet(int length){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<String> resultsArray = new ArrayList<>();
        for (int x = 0; x < length; x++){
            StringBuilder resultString = new StringBuilder();
            for(int i = 0; i < 8; i++){
                Random num = new Random();
                int pickChar = num.nextInt(27);
                resultString.append(alphabet[pickChar]);
            }
            resultsArray.add(resultString.toString());
        }
        return resultsArray;
    }
}
