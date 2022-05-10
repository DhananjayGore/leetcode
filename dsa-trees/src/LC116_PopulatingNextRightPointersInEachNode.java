import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @level : medium
 */
public class LC116_PopulatingNextRightPointersInEachNode {

public Node1 connect(Node1 root) {
        
        Queue<Node1> q = new LinkedList<>();
        
        if(root == null) return null;
        q.offer(root);
        while(! q.isEmpty()){
            int currSize = q.size();
            ArrayList<Node1> currLevel = new ArrayList<>();
            for(int i = 0; i < currSize; i++){
                Node1 currNode = q.poll();
                currLevel.add(currNode);
                
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
                
            }
            for(int j = 0; j < currSize ; j++){
                    
                    if(j == currSize-1)
                        currLevel.get(j).next = null;
                    else{
                        currLevel.get(j).next = currLevel.get(j+1);
                    }
                
            }
        }
        
        return root;
    }
	
}
