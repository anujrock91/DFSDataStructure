package Snippet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Maze3 {
	
	int min = Integer.MAX_VALUE;
	TreeSet<String> dir = new TreeSet<>();
	
	public String maze(int mat[][], int rowBall, int colBall, int rowHole, int colHole){
		int visit[][] = new int[mat.length][mat[0].length];
		DFS(rowBall, colBall, null, mat, rowHole, colHole, rowBall, colBall, 0, "", visit);
		return (dir.size()==0)?"impossible":dir.first() ;
	}
	
	public void DFS(int row, int col, String direction, int mat[][], int rowHole, int colHole, int rowBall, int colBall, int level, String d, int visit[][]){
		if(row < 0 || row >= mat.length){
			return; 
		}
		if(col < 0 || col >= mat[0].length){
			return;
		}
		if(mat[row][col] == 1){
			return;
		}
		if(level > min){ return; }
		if(row == rowHole && col == colHole){
			/*System.out.println(level);
			System.out.println(d);*/
			if(level < min){ 
				min = level;
				dir.clear();
				dir.add(d);
			}
			else if(level == min){ dir.add(d); }
			return; 
		}
		if(visit[row][col] == 1){ return; }//Already visited node
		if(direction == null){
			visit[row][col] = 1;
			DFS(row+1,col,"down",mat,rowHole,colHole,rowBall,colBall, level+1,"d",visit);
			DFS(row-1,col,"up",mat,rowHole,colHole,rowBall,colBall,level+1,"u",visit);
			DFS(row,col+1,"right",mat,rowHole,colHole,rowBall,colBall,level+1,"r",visit);
			DFS(row,col-1,"left",mat,rowHole,colHole,rowBall,colBall,level+1,"l",visit);
			visit[row][col] = 0;
		}
		else{
			visit[row][col] = 1;
			if(direction.equals("down")){
				DFS(row+1, col, "down", mat, rowHole, colHole,rowBall,colBall, level+1, d,visit);
				DFS(row, col-1, "left", mat, rowHole, colHole,rowBall,colBall, level+1, d+"l",visit);
				DFS(row, col+1, "right", mat, rowHole, colHole,rowBall,colBall, level+1, d+"r",visit);
			}
			else if(direction.equals("up")){
				DFS(row-1, col, "up", mat, rowHole, colHole,rowBall,colBall, level+1, d, visit);
				DFS(row, col-1, "left", mat, rowHole, colHole,rowBall,colBall, level+1, d+"l",visit);
				DFS(row, col+1, "right", mat, rowHole, colHole,rowBall,colBall, level+1, d+"r",visit);
			}
			else if(direction.equals("right")){
				DFS(row+1, col, "down", mat, rowHole, colHole,rowBall,colBall, level+1, d+"d",visit);
				DFS(row-1, col, "up", mat, rowHole, colHole,rowBall,colBall, level+1, d+"u",visit);
				DFS(row, col+1, "right", mat, rowHole, colHole,rowBall,colBall, level+1, d,visit);
			}
			else{
				DFS(row+1, col, "down", mat, rowHole, colHole,rowBall,colBall, level+1, d+"d",visit);
				DFS(row-1, col, "up", mat, rowHole, colHole,rowBall,colBall, level+1, d+"u",visit);
				DFS(row, col-1, "left", mat, rowHole, colHole,rowBall,colBall, level+1, d,visit);
			}
			visit[row][col] = 0;
		}
	}
	
	
	public static void main(String args[]){
		int maze[][] = new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
		System.out.println(new Maze3().maze(maze, 4, 3, 0, 1));
	}
	
	
}
