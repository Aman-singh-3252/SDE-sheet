/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    boolean isLeaf(Node node){
        if(node.left==null && node.right==null) return true;
        return false;
    }
    
    void addLeftBoundary(Node node, ArrayList<Integer> ans){
        Node curr=node.left;
        while(curr!=null){
            if(isLeaf(curr)==false) ans.add(curr.data);
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }
    void addRightBoundary(Node node, ArrayList<Integer> ans){
        Node curr = node.right;
        Stack<Integer> st=new Stack<>();
        while(curr!=null){
            if(isLeaf(curr)==false) st.push(curr.data);
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }
    void addLeaves(Node node, ArrayList<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null) addLeaves(node.left,ans);
        if(node.right!=null) addLeaves(node.right,ans);
    }
    
    public ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(isLeaf(node)==false) ans.add(node.data);
        
        addLeftBoundary(node,ans);
        addLeaves(node,ans);
        addRightBoundary(node, ans);
        return ans;
        
    }
}
