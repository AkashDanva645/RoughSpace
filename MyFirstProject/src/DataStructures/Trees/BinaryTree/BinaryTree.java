package DataStructures.Trees.BinaryTree;

import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class PreOrderTraversal {
    public static void execute(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        execute(node.left);
        execute(node.right);
    }
}

class InOrderTraversal {
    public static void execute(TreeNode node) {
        if (node == null) return;
        execute(node.left);
        System.out.print(node.val + " ");
        execute(node.right);
    }
}

class PostOrderTraversal {
    public static void execute(TreeNode node) {
        if (node == null) return;
        execute(node.left);
        execute(node.right);
        System.out.print(node.val + " ");
    }
}

class LevelOrderTraversal {
    private static Map<Integer, ArrayList<Integer>> mp;

    private static int solve(TreeNode node, int level) {
        if (node == null) return level - 1;
        if (mp.get(level) == null) {
            mp.put(level, new ArrayList<>(List.of(node.val)));
        } else {
            mp.get(level).add(node.val);
        }
        return Math.max(solve(node.left, level + 1), solve(node.right, level + 1));
     }

    public static void execute(TreeNode root) {
        mp = new HashMap<>();
        int levels = solve(root, 1);
        for (int i = 1; i <= levels; i++) {
            System.out.println(i + " -> " + mp.get(i));
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left = four;
        two.right = five;
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        four.left = eight;
        four.right = nine;
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        three.left = six;
        three.right = seven;

        PreOrderTraversal.execute(one);
        System.out.println();
        InOrderTraversal.execute(one);
        System.out.println();
        PostOrderTraversal.execute(one);
        System.out.println();
        LevelOrderTraversal.execute(one);
    }
}
