package Snippet;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}

class Node{
	int val;
	Node nextNode;
	public Node(int val){ this.val = val; }
}

public class BSTFromList {
	
	private TreeNode root;
	private Node head;
	
	
	public void addFront(int val){
		Node newNode = new Node(val);
		if(head==null){
			head = newNode;
			return;
		}
		newNode.nextNode = head;
		head = newNode;
	}
	
	
	public void addNode(int value){
		TreeNode newNode = new TreeNode(value);
		if(root == null){
			root = newNode;
		}
		else{
			addNode(root,value);
		}
	}
	
	private void addNode(TreeNode traverseNode, int value){
		if(traverseNode.val < value){
			if(traverseNode.right == null){
				TreeNode newNode = new TreeNode(value);
				traverseNode.right = newNode;
			}
			else{
				addNode(traverseNode.right, value);
			}
		}
		else{
			if(traverseNode.left == null){
				TreeNode newNode = new TreeNode(value);
				traverseNode.left = newNode;
			}
			else{
				addNode(traverseNode.left, value);
			}
		}
	}
	
	public void display(){
		displayTree(root);
		System.out.println();
	}
	
	private void displayTree(TreeNode node){
		if(node == null){ return; }
		displayTree(node.left);
		System.out.print("->" + node.val);
		displayTree(node.right);
	}
	
	
	public void BSTList(){
		TreeFromList(head, null);
	}
	
	public void TreeFromList(Node start, Node end){
		if(start==end){ return; }
		Node slow = start;
		Node fast = start;
		while(fast!=end && fast.nextNode != end){
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		addNode(slow.val);
		TreeFromList(start, slow);
		TreeFromList(slow.nextNode, end);
	}
	
	
	public static void main(String args[]){
		BSTFromList obj = new BSTFromList();
		obj.addFront(6);
		obj.addFront(5);
		obj.addFront(4);
		obj.addFront(3);
		obj.addFront(2);
		obj.addFront(1);
		obj.addFront(0);
		obj.BSTList();
		obj.display();
	}
	
}