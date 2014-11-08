import java.util.*;

/**
 * Created by admin on 2014/11/7.
 */
public class BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        TreeNode flag = new TreeNode(0);
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        q.add(flag);
        List<Integer> tmp = new ArrayList<Integer>();
        while(q.size() > 1){
            TreeNode top = q.poll();
            if(top == flag){
                ans.add(tmp);
                tmp = new ArrayList<Integer>();
                q.add(flag);
            }else{
                tmp.add(top.val);
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
        //should consider the last level, It will not execute in the while loop
        ans.add(tmp);
        return ans;
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
