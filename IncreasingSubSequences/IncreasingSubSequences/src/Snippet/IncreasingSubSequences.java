package Snippet;
import java.util.*;

public class IncreasingSubSequences {
	
	 public List<List<Integer>> findSubsequences(int[] nums) {
		 ArrayList<List<Integer>> result = new ArrayList<>();
		 ArrayList<Integer> temp = new ArrayList<>();
		 DFS(nums,0,temp, result);
		 int max = Integer.MIN_VALUE;
		 for(int i=0;i<nums.length;i++){
			 max = Integer.max(max, nums[i]);
		 }
		 getUnique(max, result);
		 return result;
	 }
	 
	 public void getUnique(int max, List<List<Integer>> result){
		 HashMap<String, List<Integer>> map = new HashMap<>();
		 for(List<Integer> li: result){
			 String s = "";
			 for(Integer i: li){
				 s = s+i;
			 }
			 if(!map.containsKey(s)){
				 map.put(s, li);
			 }
		 }
		 result.clear();
		 for(String s: map.keySet()){
			 result.add(map.get(s));
		 }
		
	 }
	 
	 
	 private void DFS(int nums[], int consider, ArrayList<Integer> temp, ArrayList<List<Integer>> result){
		 for(int i=consider;i<nums.length;i++){
			 int num = nums[i];
			 if(temp.size()!=0 && temp.get(temp.size()-1) > num ){ continue; }
			 temp.add(num);
			 if(temp.size() >= 2){
				 ArrayList<Integer> newList = new ArrayList<>(temp);
				 result.add(newList);
			 }
			 DFS(nums, i+1, temp, result);
			 temp.remove(temp.size()-1);
		 }
	 }
	 
	 
	public static void main(String args[]){
		 List<List<Integer>> res = new IncreasingSubSequences().findSubsequences(new int[]{10,7,5,8,30});
		 for(List<Integer> i: res){
			 System.out.println(i);
		 }
	 }
}
