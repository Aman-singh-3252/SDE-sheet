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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans=new ArrayList<>();

         if(root==null){
            return ans;
         }
         Deque<TreeNode> queue=new LinkedList<>();
         queue.offer(root);
         boolean f=false;

         while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            TreeNode curr=root;
            int size=queue.size();
            f=!f;
            for(int i=0;i<size;i++){
                if(f){
                    curr=queue.pollFirst();
                    if(curr.left!=null){
                        queue.offerLast(curr.left);
                    }
                    if(curr.right!=null){
                        queue.offerLast(curr.right);
                    }
                }else{
                    curr=queue.pollLast();
                    if(curr.right!=null){
                        queue.offerFirst(curr.right);
                    }
                    if(curr.left!=null){
                        queue.offerFirst(curr.left);
                    }
                }
                list.add(curr.val);
            }

            ans.add(list);
         }

         return ans;
    }
}
