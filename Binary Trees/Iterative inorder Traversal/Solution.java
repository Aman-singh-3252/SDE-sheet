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
    public List<Integer> inorderTraversal(TreeNode root) {
        // using stack for iterative Inorder-traversal
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;

        while(true){
            // if node is not null just push and go to left everytime
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                // assign node to the element top of your stack
                
                ans.add(node.val);
                node=node.right;
            }
        }

        return ans;

    }
}
