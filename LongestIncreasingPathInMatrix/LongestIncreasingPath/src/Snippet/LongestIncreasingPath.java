package Snippet;

public class LongestIncreasingPath {
	
/*
 * A point of confusion in this question arose when I thought as to what will happen if the parent is visited again
 * In such a case if a parent or the predecessor of the child is visited again
 * then it is worth remembering that in that direction the DFS has ended. Also, since the DFS of the parent is still not 
 * complete thus the returned value length[][] will be 0, which is what we want	
 */
	
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0){ return 0;}
		int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int [][]visit = new int[rows][cols];
        int length[][] = new int[rows][cols];
        for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
        	 if(visit[i][j] != 1){
        		 max = Math.max(max, DFS(i,j,Integer.MIN_VALUE, 0,length, visit, matrix));
        		}
        	 }
         }
          
       for(int i=0;i<rows;i++){
    	   for(int j=0;j<cols;j++){
    		   System.out.print(length[i][j] + " | ");
    	   }
    	   System.out.println();
       }
       System.out.println();
       return max;
    }
	
	private int DFS(int row, int col, int parent, int level, int [][] length, int visit[][], int matrix[][]){
		if(row<0 || row >= matrix.length){ return 0;}
		if(col<0 || col >= matrix[0].length){ return 0; }
		if(matrix[row][col] <= parent){ return 0; }
		if(visit[row][col] == 1){ return length[row][col]; }
		visit[row][col] = 1;
		int len1 = DFS(row+1, col, matrix[row][col], level+1, length, visit, matrix);
		int len2 = DFS(row-1, col, matrix[row][col], level+1, length, visit, matrix);
		int len3 = DFS(row, col+1, matrix[row][col], level+1, length, visit, matrix);
		int len4 = DFS(row, col-1, matrix[row][col], level+1, length, visit, matrix);
		int max = Math.max(len1, len2);
		max=Math.max(max, len3); max= Math.max(max, len4);
		int currentLen = max+1;
		length[row][col] = currentLen;
		return currentLen;
	}
	
	
	
	
	public static void main(String args[]){
		int mat[][] = new int[][]{
			{7,8,9},
			{9,7,6},
			{7,2,3}
		};
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(mat));
	}
}
