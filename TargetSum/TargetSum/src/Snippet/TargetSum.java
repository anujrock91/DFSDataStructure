package Snippet;

public class TargetSum {
	
	 public int findTargetSumWays(int[] nums, int S) {
		 return getWays(nums, 0, S, 0);
	 }
	 
	 public int getWays(int nums[], int index, int sum, int virtualSum){
		 int ways = 0;
		 if(index == nums.length-1){
			 int pos = nums[index];
			 virtualSum += pos;
			 if(virtualSum == sum){ ++ways; }
			 virtualSum -=pos;
			 
			 int neg = -nums[index];
			 virtualSum += neg;
			 if(virtualSum == sum){ ++ways; }
			 virtualSum -=neg;
			 return ways;
		 }
		 
		 //Take positive instance
		 int pos = nums[index];
		 virtualSum += pos;
		 ways += getWays(nums, index+1,sum, virtualSum);
		 virtualSum -= pos; 
		 //Take negative instance
		 int neg = -nums[index];
		 virtualSum += neg;
		 ways += getWays(nums, index+1,sum, virtualSum);
		 virtualSum -= neg;
		 return ways;
	 }
	 
	 
	 public static void main(String args[]){
		 int nums[] = new int[]{1,1,1,1,1};
		 System.out.println(new TargetSum().findTargetSumWays(nums, 3));
	 }
}
