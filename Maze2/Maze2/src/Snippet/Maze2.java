package Snippet;
/*
 * This problem is from geeksforgeeks. 
 * The question in the leetcode was closed. 
 */

public class Maze2 {
	
	public int[][] path(int[][] mat){
		int [][] path = new int[mat.length][mat[0].length];
		DFS(0, 0, path, mat);
		return path;
	}
	
	private boolean DFS(int row, int col, int[][] path, int mat[][]){
		if(row<0 || row>=mat.length){ return false; }
		if(col<0 || col>=mat[0].length){ return false; }
		if(mat[row][col] == 0){ return false; }
		if(row==(mat.length-1) && col==(mat[0].length-1)){
			path[row][col] = 1;
			return true; 
		}
		if(DFS(row+1, col, path, mat) || DFS(row, col+1, path, mat)){
			path[row][col] = 1;
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public static void main(String args[]){
		int [][] mat = new int[][]{
		{1, 0, 0, 0},
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 1}};
		int [][] path = new Maze2().path(mat);
		//printing the matrix
		for(int []row: mat){
			for(Integer i: row){
				System.out.print(i + " | ");
			}
			System.out.println();
		}
		System.out.println();
		for(int []row: path){
			for(Integer i: row){
				System.out.print(i + " | ");
			}
			System.out.println();
		}
	}
}
