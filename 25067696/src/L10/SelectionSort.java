package L10;

/* Selection Sort
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};

        System.out.println("Original Array: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        int[] arrSmallestToLargest = selectionSortSmallestToLargest(arr);

        System.out.println("Sort Smallest: ");
        for(int i = 0; i < arrSmallestToLargest.length; i++) {
            System.out.print(arrSmallestToLargest[i]);
            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();


        int[] arrLargestToSmallest = selectionSortLargestToSmallest(arr);

        System.out.println("Sort Largest: ");
        for(int i = 0; i < arrLargestToSmallest.length; i++) {
            System.out.print(arrLargestToSmallest[i]);
            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int[] selectionSortSmallestToLargest(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int[] selectionSortLargestToSmallest(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        return arr;
    }
}
