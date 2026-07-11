/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int max=0;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        max=root.val;
        solve(root);
        return max;
    }
    static int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        // if root is null return 0;

        int left=Math.max(0, solve(root.left));
        int right=Math.max(0, solve(root.right));
        // to avoid negative to be taken , it could possibly reduce the total
        // imagine Now if this root was part of a bigger tree and both the 
        //children were negatives it would have passed eg. 20+Max(-15,-7)
        //total would be 13,so 13 would have passed .

        // in this case 20+max(0,0) would be passed.

        max=Math.max(max, root.val+left+right);
        //same concept as diamter of binary tree.

        return root.val+Math.max(left,right);
    }
}
