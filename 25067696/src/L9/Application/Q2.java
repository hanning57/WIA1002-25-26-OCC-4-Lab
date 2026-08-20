package L9.Application;

import java.util.Scanner;

/*
 * 2. Binomial Expansion: (a + b)^n = C(n, 0) * a^n * b^0 + C(n, 1) * a^(n-1) * b^1 + ... + C(n, n) * a^0 * b^n
*/

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the degree of your binomial expression: ");
        String degree = sc.nextLine();
        int n = Integer.parseInt(degree);

        System.out.print("(x+y)^" + n + " = ");

        for(int k = 0; k <= n; k++) {
            System.out.print(binomial(n, k) + "x^" + (n - k) + "y^" + k);
            if(k < n) {
                System.out.print(" + ");
            }
        }
        System.out.println();

        sc.close();

    }

    public static int binomial(int n, int k) {
        
        if(k == n || k == 0) {
            return 1;
        } else 
            return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}
