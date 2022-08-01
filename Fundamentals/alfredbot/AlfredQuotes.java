import java.util.Date;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        
        return "'ello, " + name + ". Lovely to see ya, gov.";
    }
    
    public String dateAnnouncement() {
        Date greetingDate = new Date();
        return "Oi it is " + greetingDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1){
            return "Oi! I 'unno why yer askin her...I'm on it, gov";
        }
        else if (conversation.indexOf("Alfred") > -1){
            return "You got it, gov";
        }
        return "Right I'm busy anyway";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

