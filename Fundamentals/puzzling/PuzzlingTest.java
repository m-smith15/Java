import java.util.ArrayList;
import java.util.Random;

public class PuzzlingTest {
    
	public static void main(String[] args) {
		Puzzling generator = new Puzzling();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	//..
		// Write your other test cases here.
		//..

        char randoChar = generator.getRandomLetter();
        System.out.println(randoChar);

        StringBuilder randoPass = generator.getRandomPassword();
        System.out.println(randoPass);

        ArrayList<String> passwordSet = generator.getNewPasswordSet(5);
        System.out.println(passwordSet);
	}
}
