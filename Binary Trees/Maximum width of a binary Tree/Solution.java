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
    static class Pair{
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        int max=0;

        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            int size=queue.size();
            int start=0; int end=0;
            int minIndex=queue.peek().index;
            //keep track of minimum index beforehand

            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                TreeNode node=curr.node;
                int idx=curr.index;

                int currIndex=curr.index-minIndex;
                if(i==0){
                    start=idx;
                }

                if(i==size-1){
                    end=idx;
                }

                if(node.left!=null){
                    queue.offer(new Pair(node.left,2*currIndex+1));
                }
                //left index starting with 0,1,2...
                //the goal is to start the numbering for each level
                //from 0,1,2,3.... because indexing from 1 to 10^5 would be quiet large

                if(node.right!=null){
                    queue.offer(new Pair(node.right,2*currIndex+2));
                }
                //if currindex=2 then the left one would be 2*2+1=5 and right would be 2*2+2=6 
                // so this way we can assign all the possible index

 
            }

            max=Math.max(max,end-start+1);
        }

        return max;
    }
}
