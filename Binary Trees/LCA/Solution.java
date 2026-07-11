/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
    TreeNode solve(TreeNode node, TreeNode p, TreeNode q){
        if(node==null){
            return null;
        }

        if(node==p ||  node==q){
            return node; // if the node is either p or q return node. 
        }

        TreeNode left=solve(node.left,p,q);
        TreeNode right=solve(node.right,p,q);

        if(left!=null && right!=null){
            return node; // lca founded return the node.
        }

        if(left==null){
            return right; // we will only return a node when we find p or q otherwise we will return null
        }

        return left;
    }
}
