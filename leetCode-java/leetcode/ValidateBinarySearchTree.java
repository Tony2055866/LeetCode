import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * Created by GaoTong on 2014/11/11.
 * copyright: www.acmerblog.com
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class NodeWrapper{
        TreeNode node;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, new NodeWrapper());
    }

    boolean helper(TreeNode root, NodeWrapper pre){
        if(root == null)
            return true;
        if(!helper(root.left, pre))
            return false;
        //判断当前节点和上一个节点是否是有序的
        if(pre.node != null && root.val <= pre.node.val) return false;
        pre.node = root;
        return helper(root.right, pre);
    }

    public boolean isValidBST2(TreeNode root){
        return helper2( root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper2(TreeNode root, int maxValue, int minValue) {
        if(root == null) return true;
        if(root.val >= maxValue || root.val <= minValue) return false;
        return helper2(root.left, root.val, minValue) && helper2(root.right, maxValue, root.val);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        System.out.println(v.isValidBST(root));
        System.out.println(v.isValidBST2(root));
    }

}

