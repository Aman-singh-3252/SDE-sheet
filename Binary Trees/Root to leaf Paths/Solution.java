/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        solve(ans,root,list);
        return ans;
    }
    void solve(ArrayList<ArrayList<Integer>> ans,Node node,ArrayList<Integer> list){
        if(node==null) return;
        
        list.add(node.data);
        
        if(node.left==null && node.right==null){
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        
        solve(ans,node.left,list);
        solve(ans,node.right,list);
        
        list.remove(list.size()-1);
        
    }
}





