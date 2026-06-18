package L11;

import java.util.ArrayList;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        // Define the input data
        int[] data = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        
        // 1. Insert Data
        System.out.print("Input Data: ");
        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
            System.out.print(data[i] + (i == data.length - 1 ? "" : ", "));
        }
        System.out.println();
        
        // 2. Traversals
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.println();
        
        System.out.print("Postorder: ");
        tree.postorder();
        System.out.println();
        
        System.out.print("Preorder: ");
        tree.preorder();
        System.out.println();
        
        // 3. Tree Properties
        System.out.println("Height of BST: " + tree.height());
        System.out.println("Root for BST is: " + tree.getRoot());
        
        // 4. Search
        System.out.println("Check whether 10 is in the tree? " + tree.search(10));
        
        // 5. Delete
        System.out.println("Delete 53");
        tree.delete(53);
        
        System.out.print("Updated Inorder data (sorted): ");
        tree.inorder();
        
        // 6. Extremes
        System.out.println("Min Value :" + tree.minValue());
        System.out.println("Max Value :" + tree.maxValue());
        
        // 7. Path
        System.out.print("A path from the root to 6 is: ");
        ArrayList<TreeNode<Integer>> path = tree.path(6);
        for (TreeNode<Integer> node : path) {
            System.out.print(node.element + " ");
        }
        System.out.println();
    }
}
