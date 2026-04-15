package L5.Kindergarden;

import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList<String> kindergarten = new StudentList<>();

        System.out.println("Enter your student name list. Enter \'n\' to end...");
        while(true) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("n")) {
                break;
            }
            kindergarten.add(input);
        }

        System.out.println("\nYou have entered the following students' name: ");
        kindergarten.printList();

        System.out.printf("\n\nThe number of students entered is: %d%n", kindergarten.getSize());
        
        System.out.println("\nEnter the exixting student name that u want to rename: ");
        String nameReplace = sc.nextLine();
        System.out.println("\nEnter the new name: ");
        String nameNew = sc.nextLine();
        kindergarten.replace(nameReplace, nameNew);

        System.out.println("\nThe new student list is: ");
        kindergarten.printList();

        System.out.println("\n\nDo you want to remove any of your student name? Enter \'y\' for yes, \'n\' to proceed.");
        String answer = sc.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println("\nEnter a student name to remove: ");
            String nameRemoved = sc.nextLine();
            kindergarten.removeElement(nameRemoved);

            System.out.printf("\nThe number of updated students is: %d%n", kindergarten.getSize());
            System.out.println("The updated student list is: ");
            kindergarten.printList();
        }

        System.out.println("\n\nAll student data captures complete. Thank you!");

        sc.close();
    }

    
}
