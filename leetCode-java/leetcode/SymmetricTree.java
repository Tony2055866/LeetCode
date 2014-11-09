
/**
 * Created by GaoTong on 2014/11/9.
 * copyright: www.acmerblog.com
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

   1
  / \
  2   2
 / \ / \
 3  4 4  3
 But the following is not:
   1
  / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */


public class SymmetricTree {
    static class TreeNode {
           int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null ) return true;
        if(leftNode == null || rightNode == null) return false;
        if(leftNode.val != rightNode.val) return  false;
        boolean isLeft = isSymmetric(leftNode.left, rightNode.right);
        boolean isRight = isSymmetric(leftNode.right, rightNode.left);
        return isLeft && isRight;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
