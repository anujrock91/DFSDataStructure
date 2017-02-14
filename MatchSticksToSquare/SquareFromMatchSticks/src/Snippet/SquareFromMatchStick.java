package Snippet;

public class SquareFromMatchStick {
	 
	public boolean makesquare(int[] nums) {
		int sum = 0;
		if(nums.length < 4){ return false; }
		for(int num: nums){
			sum += num;
		}
		if(sum%4 != 0){ return false; }
		else{
			return DFS(nums, new int[4], 0, sum/4);
		}
	}
	
	private boolean DFS(int nums[], int sides[], int level, int target ){
		if(level == nums.length-1){
			for(int i=0;i<4;i++){
				int num = nums[level];
				if(num+sides[i] == target){
					sides[i] +=num;
					if(sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3]){ return true; }
					sides[i] -=num;
				}
			}
			return false;
		}
		int num = nums[level];
		for(int i=0;i<4;i++){
			if(sides[i]+num <=target){
				sides[i] +=num;
				if(DFS(nums,sides,level+1,target)){ return true; }
				sides[i] -=num;
			}
		}
		return false;
	}
	    
	
	
	
	public static void main(String args[]){
		System.out.println(new SquareFromMatchStick().makesquare(new int[] {1,1,2,2,2} ));
	}
}
