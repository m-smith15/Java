
public class SwitchAndTernary {
    public static void main( String args [] ) {

        int month = 3;

        int age = 25;

        if ( age < 50) {
            System.out.println( "You have less than 50 years!");
        }
        else {
            System.out.println( "You have more than 50 years!");
        }
            // condition ? __true__ : __false__
        String result =  ( age < 50 )  ? "*You have less than 50 years!" : "*You have more than 50 years!"; 
        System.out.println( result );

        switch(month ) {
            case 1:
            case 3: 
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: System.out.println( "31 days!");
                break;
            case 2: System.out.println("28 days!");
                break;
            default: System.out.println("Invalid month");
        }
    }
}
