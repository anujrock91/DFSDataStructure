package Snippet;
import java.util.*;

public class ParseTernary {
	
	public String evaluate(String s){
		if(s.length() == 1 || s.length()==0){ return s; }
		else if(s.length() == 3){ 
			if(s.charAt(0) == 'T'){ return ""+s.charAt(s.length()-1); }
			else{ return  ""; }
		}
		else if(s.length() < 3){
			return "";
		}
		String result = "";
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		for(i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c == '?'){
				stack.push(i);
			}
			else if(c == ':'){
				int index = stack.pop();
				String conditionResult = "";
				if(s.charAt(index-1) == 'T'){
					conditionResult = s.substring(index+1, i);
				}
				else{
					conditionResult = s.substring(i+1);
				}
				result = evaluate(conditionResult);
				break;
			}
		}
		
		if(i==s.length()){ result = ""+s.charAt(stack.peek()+1); }
		
		while(!stack.isEmpty()){
			int index = stack.pop();
			String left = ""+s.charAt(index-1);
			String center = "?";
			String right = result;
			result = evaluate(left+center+right);
		}
		
		return result; 
	}
	
	
	public static void main(String args[]){
		System.out.println(new ParseTernary().evaluate("T?F?T?4"));	
	}
	
	
	
}
