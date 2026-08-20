package L9.Recursion;

/* 3. Write a recursive method called exponent(x, y) to perform exponentiation return x^7,
 *      assuming y >= 0.
 *      Example: exponent(10, 3)
 *      Output: will produce an output of 1000
 */

public class Exponential {

    public static void main(String[] args) {
        System.out.println(exponent(10, 3));
    }

    public static long exponent(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return x * exponent(x, y - 1);
        }
    }
}
