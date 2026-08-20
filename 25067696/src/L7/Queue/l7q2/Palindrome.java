package L7.Queue.l7q2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine().toLowerCase().trim();

        System.out.println("Is " + word + " a Panlindrome? ");
        System.out.println("Ans: " + isPanlindrome(word));

        sc.close();
    }

    public static boolean isPanlindrome(String s) {
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for(int i = s.length() - 1; i >= 0 ; i--) {
            if(queue.remove() != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
