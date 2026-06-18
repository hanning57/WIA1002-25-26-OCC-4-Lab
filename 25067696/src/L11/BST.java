package L11;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size = 0;

    public boolean search(E e) {
        TreeNode<E> current = root;
        
        while(current != null) {
            if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean insert(E e) {
        TreeNode<E> current = root;
        TreeNode<E> parent = null;

        if (root == null) {
            root = new TreeNode<E>(e);
        } else {
        // Locate the parent node
            current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<E>(e);
            } else {
                parent.right = new TreeNode<E>(e);
            }
        }
        size ++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if(node == null) return -1;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public E getRoot() {
        if(root == null) {
            return null;
        }
        return root.element;
    }

    public E minValue() {
        if(root == null) return null;
        TreeNode<E> current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current.element;
    }

    public E maxValue() {
        if(root == null) return null;
        TreeNode<E> current = root;
        while(current.right != null) {
            current = current.right;
        }
        return current.element;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> path = new ArrayList<>();
        
        TreeNode<E> current = root;
        while(current != null) {
            path.add(current);

            if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return path;
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        
        while(current != null) {
            if(e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if(current == null) {
            return false;
        }
        
        // Case A: Current node has no left child
        if(current.left == null) {
            if(parent == null) {
                root = current.right;
            } else if(e.compareTo(parent.element) < 0) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case B: Current node has a left child but no right child
        else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (e.compareTo(parent.element) < 0) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } 
        // Case C: Current node has two children
        else {
            // Find the rightmost node in the left subtree (In-order predecessor)
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            
            // Copy the value from the predecessor to current
            current.element = rightMost.element;
            
            // Eliminate the duplicate predecessor node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else {
                // This happens if current.left had no right children
                parentOfRightMost.left = rightMost.left;
            }
        }

        size --;
        return true;
    }

    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }

    protected void inorder(TreeNode<E> root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
        
    }

    public void inorder() {
        inorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    public void preorder() {
        preorder(root);
    }
}
