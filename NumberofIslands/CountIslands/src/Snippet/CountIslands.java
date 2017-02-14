package Snippet;

public class CountIslands {
	
	public int countIslands(int[][]mat){
		int count =0;
		for(int row =0; row<mat.length;row++){
			for(int col=0;col<mat[0].length;col++){
				if(mat[row][col] == 1){
					++count;
					DFS(row,col,mat);
				}
			}
		}
		return count;
	}
	
	
	private void DFS(int row, int col, int mat[][]){
		if(row<0 || row>=mat.length){ return; }
		if(col<0 || col>=mat[0].length){ return; }
		if(mat[row][col] == -1 || mat[row][col] == 0){ return; }//already visited
		else{
			mat[row][col] = (-1*mat[row][col]);
			DFS(row+1,col,mat);
			DFS(row-1,col,mat);
			DFS(row,col+1,mat);
			DFS(row,col-1,mat);
		}
	}
	
	
	public static void main(String args[]){
		int [][] mat = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		System.out.println(new CountIslands().countIslands(mat));
	}
	
}
