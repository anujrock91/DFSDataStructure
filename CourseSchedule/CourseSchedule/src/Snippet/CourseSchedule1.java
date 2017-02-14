package Snippet;
import java.util.HashMap;
import java.util.ArrayList;

public class CourseSchedule1 {
	
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
		 int nums[] = new int[numCourses];
		 HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		 for(int edge[] : prerequisites){
			 if(map.containsKey(edge[1])){
				 map.get(edge[1]).add(edge[0]);
			 }
			 else{
				 ArrayList<Integer> newList = new ArrayList<>();
				 newList.add(edge[0]);
				 map.put(edge[1], newList);
			 }
		 }
		 
		 for(int i=0;i<numCourses;i++){
			 if(nums[i] != 1){
				 if(!isPossible(nums, map, nums[i])){
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 
	 private boolean isPossible(int nums[], HashMap<Integer, ArrayList<Integer>> map, int current){
		 if(nums[current] == 1){//Visiting
			 return false;
		 }
		 else if(!map.containsKey(current)){//visited
			 nums[current] = 2;
			 return true;
		 }
		 else{
			 nums[current] = 1;
			 ArrayList<Integer> childs = map.get(current);
			 for(int i: childs){
				 if(nums[i] != 2){
					 if(!isPossible(nums, map, i)){ return false; }
				 }
			 }
			 nums[current] = 2;
			 return true;
		 }
	 }
	
}
