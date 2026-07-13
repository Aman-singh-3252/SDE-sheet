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
    List<Integer> result=new ArrayList<>();
    Map<TreeNode,TreeNode> map=new HashMap<>();
    Set<TreeNode> vis=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildmap(root);
        find(target,0,k);
        return result;

    }
    public void buildmap(TreeNode node){
        // build the map to travel upwards also using map
        if(node.left!=null){
            map.put(node.left,node);
            buildmap(node.left);
        }

        if(node.right!=null){
            map.put(node.right,node);
            buildmap(node.right);
        }

    }
    public void find(TreeNode node,int distance,int k){
        if(node ==null || vis.contains(node)){
            return;
        }
        // simple dfs

        vis.add(node);
        if(distance==k){
            result.add(node.val);
            return;
        }

        if(node.left!=null){
            find(node.left,distance+1,k);
        }

        if(node.right!=null){
            find(node.right,distance+1,k);
        }

        if(map.get(node)!=null){
            // for travelling upwards like in graph using map
            find(map.get(node),distance+1,k);
        }
    }
}
