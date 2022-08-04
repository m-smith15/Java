import java.util.HashMap;
import java.util.Set;

public class hashmatique {
        public static void main(String[] args){
            HashMap<String, String> songlist = new HashMap<String, String>();
            songlist.put("T1: Why you, Nancy Drew", "L1: Loook at all these shrimp in the ocean");
            songlist.put("T2: Nancy Drew, yablewit", "L2: If only you didn't find out my devious plan to scare people away from the town");
            songlist.put("T3: I'm going to jail because of Nancy Drew", "L3: who knew scamming people out of thousands of dollars was a criminal activity");
            songlist.put("T4: Nancy Drew I'm in love with you", "L4: I'll right my wrongs in jail but you're my soulmate Nancy Drew");
            //get keys 
            Set <String> keys = songlist.keySet();
            System.out.println(songlist.get("T1: Why you, Nancy Drew"));
            System.out.println("------------");
            for(String key : keys){
                System.out.println(key);
                System.out.println(songlist.get(key));
            }
        }
}
