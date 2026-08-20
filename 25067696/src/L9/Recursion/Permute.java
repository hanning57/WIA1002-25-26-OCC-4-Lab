package L9.Recursion;

/* 2. Write a recursive method called permuteString() that will find 
 *      and print all the possiblilities to arrage the letters of a given word.
 *      Example: Input String: "abc"
 *      Output Permutation: ["abc", "acb", "bac", "bca", "cab", "cba"]
 */

public class Permute {

    public static void main(String[] args) {
        permuteString("", "abc");
    }

    public static void permuteString(String beginning, String ending) {
        if (ending.length() <= 1) {
            System.out.println(beginning + ending);
        } else {
            for (int i = 0; i < ending.length(); i++) {
                String newBeginning = ending.substring(0, i) + ending.substring(i + 1);
                permuteString(beginning + ending.charAt(i), newBeginning);
            }
        }
    }
}
