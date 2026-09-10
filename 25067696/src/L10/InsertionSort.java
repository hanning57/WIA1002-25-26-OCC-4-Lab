package L10;

/* Insertion Sort
*/

public class InsertionSort {
    public static void main(String[] args) {
        int[] inputArray = {10, 34, 2, 56, 7, 67, 88, 42};
        int[] sortedArray = insertionSort(inputArray);

        System.out.println("Original Array: ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            if (i < inputArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("Sorted Array: ");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
            if (i < sortedArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

    
    }

    public static int[] insertionSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

//     public static int[] insertionSort(int[] arr) {
//         for (int i = 1; i < arr.length; i++) {
//             int key = arr[i];
//             int j = i - 1;

//             while (j >= 0 && arr[j] > key) {
//                 arr[j + 1] = arr[j];
//                 j--;
//             }
//             arr[j + 1] = key;
//         }
//         return arr;
//     }

}
