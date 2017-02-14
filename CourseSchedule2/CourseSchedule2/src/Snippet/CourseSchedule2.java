package Snippet;
import java.util.*;
import java.util.HashMap;

/*
 * Always remember
 * if we keep on adding from the end then no matter which node we pick
 * as the first node to start the DFS we will get the correct order
 * */

public class CourseSchedule2 {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int [] nums = new int[numCourses];
		int [] result = new int[numCourses]; 
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int [] edge: prerequisites){
			if(map.containsKey(edge[1])){
				map.get(edge[1]).add(edge[0]);
			}
			else{
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(edge[0]);
				map.put(edge[1], newList);
			}
		}
		int count = (numCourses-1);
		for(int i=0;i<numCourses; i++){
			if(nums[i] != 2){
				count = courseOrder(nums, i, map, result, count);
				if(count == -99){ return new int[]{};}
			}
		}
		
		return result;
	}
	
	
	public int courseOrder(int nums[], int current, HashMap<Integer, ArrayList<Integer>> map, int[]result, int count){
		if(nums[current] == 1){
			return -99;
		}
		else if(!map.containsKey(current)){
			nums[current] = 2;
			result[count] = current;
			return count-1;
		}
		else{
			nums[current] = 1;
			ArrayList<Integer> childs = map.get(current);
			for(Integer i: childs){
				if(nums[i] != 2){
					count = courseOrder(nums, i, map, result, count);
					if(count == -99){ return count; }
				}
			}
			nums[current] = 2;
			result[count] = current;
			return count-1;
		}
	}
	
	
	public static void main(String args[]){
		int [] r = new CourseSchedule2().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
		for(int i: r){
			System.out.print(i + "|");
		}
		System.out.println();
	}
}