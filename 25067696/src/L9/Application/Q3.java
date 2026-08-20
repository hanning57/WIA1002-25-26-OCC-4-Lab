package L9.Application;

import java.util.Scanner;

public class Q3 {

    public static int TowerOfHanoi(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * TowerOfHanoi(n - 1) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Part A:");
        System.out.println("The recurrence relation is T(n) = 2T(n-1) + 1, with T(1) = 1");

        System.out.println("\nPart B:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        String disks = sc.nextLine();
        int n = Integer.parseInt(disks);

        System.out.println("The number of moves required to solve the Tower of Hanoi problem with " + n + " disks is: " + TowerOfHanoi(n));

        sc.close();
    }
}
