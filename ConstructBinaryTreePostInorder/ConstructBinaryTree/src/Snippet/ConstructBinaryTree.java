package Snippet;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class wrapper{
	int pointer = 0;
	TreeNode node = null;
}

public class ConstructBinaryTree {

	
	public void display(TreeNode root){
		displayTree(root);
		System.out.println();
	}
	
	private void displayTree(TreeNode root){
		if(root == null){ return; }
		displayTree(root.left);
		System.out.print("->"+root.val);
		displayTree(root.right);
	}
	
	
	public TreeNode construct(int[]inorder, int preorder[]){
		return construct(inorder, preorder, 0).node;
	}
	
	public wrapper construct(int[]inorder, int preorder[], int pointer){
		if(inorder.length == 0){ 
			wrapper obj = new wrapper();
			obj.pointer = pointer;
			return obj;
		}
		int num = preorder[pointer];
		++pointer;
		TreeNode newNode = new TreeNode(num);
		//Constructing break arrays
		int count = 0;
		for(int i: inorder){
			++count;
			if(i == num){ break; } 
		}
		//Filling the right and left array
		int leftArr[] = new int[count-1];
		for(int i=0;i<leftArr.length;i++){
			leftArr[i] = inorder[i];
		}
		int rightArr[] = new int[inorder.length-count];
		for(int i=0;i<rightArr.length;i++){
			rightArr[i] = inorder[i+count];
		}
		wrapper leftObj = construct(leftArr, preorder, pointer);
		wrapper rightObj = construct(rightArr, preorder, leftObj.pointer);
		newNode.left = leftObj.node;
		newNode.right = rightObj.node;
		wrapper current= new wrapper();
		current.pointer = rightObj.pointer;
		current.node = newNode;
		return current;
	}
	
	
	public static void main(String args[]){
		ConstructBinaryTree obj = new ConstructBinaryTree();
		int [] inorder = new int[]{10,30,45,50,55,65,70,75,77,80,90,100};
		int [] pre = new int[]{75,50,30,10,45,65,55,70,80,77,90,100};
		TreeNode n = obj.construct(inorder, pre);
		obj.display(n);
	}
	
}