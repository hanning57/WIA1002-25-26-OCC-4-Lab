package L9.Recursion;

/* 1. Create a recursive function that accepts a String parameter 
 *      and substitute any of the lowercase "a" (no application to uppercase "A") found with "i" char.
 *      Example: subsituteAI("flabbergasted") returns "flibbergisted"
 *      Example: subsituteAI("Astronaut") returns "Astroniut"
 */

public class SubsituteAI {

    public static void main(String[] args) {
        System.out.println(subsituteAI("flabbergasted"));
        System.out.println(subsituteAI("Astronaut"));
    }    

    public static String subsituteAI(String str) {

        // Base case
        if(str.length() == 0)
            return str;

        // Recursive case
        else if (str.charAt(0) == 'a')
            return 'i' + subsituteAI(str.substring(1));
        
        else
            return str.charAt(0) + subsituteAI(str.substring(1));
    }
}