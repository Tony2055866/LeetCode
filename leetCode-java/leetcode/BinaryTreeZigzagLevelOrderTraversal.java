
import java.util.*;

/**
 * Created by admin on 2014/11/7.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        boolean isOdd = false; //should this level be reversed
        TreeNode flag = new TreeNode(0);
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        q.add(flag);
        List<Integer> tmp = new ArrayList<Integer>();
        while(q.size() > 1){
            TreeNode top = q.poll();
            if(top == flag){
                if(isOdd) Collections.reverse(tmp);
                ans.add(tmp);
                tmp = new ArrayList<Integer>();
                isOdd = !isOdd;
                q.add(flag);
            }else{
                tmp.add(top.val);
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
        //should consider the last level, It will not execute in the while loop
        if(!isOdd) Collections.reverse(tmp);
        ans.add(tmp);
        return ans;
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
}
