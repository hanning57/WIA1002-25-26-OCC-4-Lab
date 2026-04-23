package L6.l6q1;

public class TestMyStack {
    public static void main(String[] args) {

        System.out.println("--- Character ---");
        MyStack<Character> charStack = new MyStack<>();

        charStack.push('a');
        charStack.push('b');
        charStack.push('c');

        System.out.println("=== Current List ===");
        System.out.println(charStack.toString());

        System.out.println("\n=== Look for 'b' ===");
        System.out.println("Ans: " + charStack.search('b'));

        System.out.println("\n=== Look for 'k' ===");
        System.out.println("Ans: " + charStack.search('k'));




        System.out.println("\n\n--- Integer ---");
        MyStack<Integer> intStack = new MyStack<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("=== Current List ===");
        System.out.println(intStack.toString());

        System.out.println("\n=== Look for '6' ===");
        System.out.println("Ans: " + intStack.search(6));
    }
}
