package Snippet;
import java.util.*;

/*
 * The only thing to keep in mind is the fact that when we do a DFS
 * nodes already visited are already existing 
 * Hence we need to just keep track of them
 */

class UndirectedGraphNode {
	int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class CloneGraph {
	
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null){ return null; }
	        UndirectedGraphNode parent = new UndirectedGraphNode(node.label);
	        HashMap<Integer, UndirectedGraphNode> cloned = new HashMap<>();
	        HashSet<UndirectedGraphNode> visited = new HashSet<>();
	        cloned.put(node.label, parent);
	        visited.add(node);
	        for(UndirectedGraphNode child: node.neighbors){
	        	clone(child, parent, cloned, visited);
	        }
	        
	        return parent;
	 }
	 
	 public void clone(UndirectedGraphNode node, UndirectedGraphNode parent, HashMap<Integer,UndirectedGraphNode> cloned, HashSet<UndirectedGraphNode> visited){
		 if(node == null && parent!=null){ return; }
		 if(node == null && parent==null){ return; }
		 if(visited.contains(node)){
			 parent.neighbors.add(cloned.get(node.label));
			 return;
		 }
		 else{
			 visited.add(node);
			 UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			 if(parent!=null){
				 parent.neighbors.add(newNode);
			 }
			 else{
				 parent = newNode;
			 }
			 cloned.put(node.label, newNode);
			 for(UndirectedGraphNode child: node.neighbors){
				clone(child, newNode, cloned, visited); 
			 }
		 }
	 }
}
