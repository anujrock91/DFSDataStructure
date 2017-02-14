package Snippet;
import java.util.*;

class wrapper{
	Integer num = null;
	String result = "";
}

public class DecodeString {
	
	public String decodeString(String s){
		if(s == null){ return null; }
		if(s.length() == 0){ return ""; }
		int digit = 0;
		//setting the first element in stack
		Stack <wrapper> stack = new Stack<>();
		stack.push(new wrapper());
		stack.peek().num = 1;
		//for each character in string to be decoded
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				digit = (digit*10+(c-'0'));
			}
			else if(c == '['){
				wrapper obj = new wrapper();
				obj.num = digit;
				digit = 0;
				stack.push(obj);
			}
			else if(c == ']'){
				wrapper obj = stack.pop();
				String desirialize = deserialize(obj);
				stack.peek().result = (stack.peek().result+desirialize);
			}
			else{
				wrapper obj = stack.peek();
				obj.result = obj.result+c;
			}
		}
		
		return deserialize(stack.peek());
	}
	
	
	public String deserialize(wrapper obj){
		String res = "";
		for(int i=0;i<obj.num;i++){
			res = res+obj.result;
		}
		return res;
	}
	
	
	public static void main(String args[]){
		System.out.println(new DecodeString().decodeString("3[a2[c]]ef"));
	}
}
