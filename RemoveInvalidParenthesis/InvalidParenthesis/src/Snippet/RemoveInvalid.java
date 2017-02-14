package Snippet;
import java.util.List;
import java.util.ArrayList;

public class RemoveInvalid {
	
	int max = Integer.MIN_VALUE;
	List<String> result = new ArrayList<String>();
	
	public List<String> getRemoved(String s){
		DFS(s, "",0,0);
		return result;
	}
	
	public void DFS(String left, String right, int count, int maxLeft){
		if(left.length() == 0){
			if(count==0){
				if(maxLeft > max){
					max = maxLeft;
					result.clear();
					result.add(right);
				}
				else if(maxLeft==max){
					if(!result.contains(right)){ result.add(right); }
				}
			}
		}
		else{
			char c = left.charAt(0);
			if(c == '('){
				String tempLeft = left.substring(1);
				DFS(tempLeft, right+'(',count+1, maxLeft+1);
				DFS(tempLeft, right, count, maxLeft);
			}
			else if(c == ')'){
				String tempLeft = left.substring(1);
				if(count>0){
					DFS(tempLeft, right+')',count-1,maxLeft);
				}
				DFS(tempLeft, right, count, maxLeft);
			}
			else{
				String tempRight = right+c;
				String tempLeft = left.substring(1);
				DFS(tempLeft, tempRight, count, maxLeft);
			}
		}
	}
	
	
	public static void main(String args[]){
		System.out.println(new RemoveInvalid().getRemoved(")("));
	}
}