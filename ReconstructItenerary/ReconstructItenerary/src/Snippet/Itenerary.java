package Snippet;
import java.util.*;

public class Itenerary {
	
	public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		//Inserting in Hashmap
		for(int row =0; row< tickets.length; row++){
			String key = tickets[row][0];
			String value = tickets[row][1];
			if(map.containsKey(key)){
				map.get(key).add(value);
			}
			else{
				PriorityQueue<String> q = new PriorityQueue<>();
				q.add(value);
				map.put(key, q);
			}
		}
		
		List<String> result = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		String destination = "";
		while(!stack.isEmpty() && !map.isEmpty()){
			String key = stack.pop();
			if(!map.containsKey(key)){
			    destination = key;
			    stack.push(result.remove(result.size()-1));
			}
			else{
			    result.add(key);
			    String value = map.get(key).remove();
    			stack.push(value);
    			if(map.get(key).size() == 0){
    				map.remove(key);
    			}    
			}
		}
		
		if(!stack.isEmpty()){ result.add(stack.pop()); }
		if(!destination.equals("")){ result.add(destination); }
		return result;
    }
	
	
	public static void main(String args[]){
		String mat[][] = new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},
			{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
		System.out.println(new Itenerary().findItinerary(mat));
	}
}