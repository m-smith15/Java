package class_notes;
import java.util.ArrayList;

public class StringsAndArrays {

    public static void main( String args[]){
        
        int scores[] = new int[10];
        ArrayList<Integer> listOfScores = new ArrayList<Integer>();

        scores[0] = 100;
        listOfScores.add( 100);
        scores[1] = 200;
        listOfScores.add(200);

        System.out.println( "Scores: " + scores.length);
        System.out.println("ListOfScores: " + listOfScores.size() );

        String name = "Alex";

        System.out.println( name.length() );
        System.out.println(name.charAt(1));


    }
}
