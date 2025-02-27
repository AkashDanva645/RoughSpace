package DataStructures.Trees.BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class BinarySearchTreeUtils {

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }


    public TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (root.val == key) return root;
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }


    public boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;

        boolean left = false, right = false;
        if (root.val < key) right = search(root.right, key);
        else if (root.val > key) left = search(root.left, key);

        return left || right;
    }


    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = delete(root.left, key);
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode succ = getSuccessor(root);
            root.val = succ.val;
            root.right = delete(root.right, succ.val);
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }



}

public class BinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(20);
        root.right = new TreeNode(500);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(40);

        BinarySearchTreeUtils sol = new BinarySearchTreeUtils();
        sol.delete(root, 20);

        sol.inorderTraversal(root);
    }
}
