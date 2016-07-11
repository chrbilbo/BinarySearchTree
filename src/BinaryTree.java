

public class BinaryTree {
	
	Node root;
	
	public void insertNode (int value){
		//create new node
		Node newNode = new Node(value);
		
		//if no root newNode is root
		if(root == null){
			root = newNode;
		}else{
			//set the current node to root and start traversing tree
			Node currentNode = root;
			
			//set parent for new node
			Node parentNode;
			
			do{
				//start at top root parent
				parentNode = currentNode;
				
				//check if node goes on left side of tree
				if (value < currentNode.value){
					currentNode = currentNode.left;
					
					//left side has now children
					if(currentNode == null){
						//new node goes on left side
						parentNode.left = newNode;
						return;
					}
				}else{
					//starts checking right side
					currentNode = currentNode.right;
					
					//if right child has no children
					if(currentNode == null){
						//node goes on right side
						parentNode.right = newNode;
						return;
					}
				}
			}while (true);
		}
	}
	
	public int maxValue(Node newNode){
		while(newNode.right != null){
			newNode = newNode.right;
		}
		return newNode.value;
	}
	
	public Node deleteNode(int value){
		Node currentNode = root;
		
		do{
			if(value < currentNode.value){
				currentNode = currentNode.left;
			}else{
				currentNode = currentNode.right;
			}
			
			if(currentNode == null){
				return null;
			}
		}while(currentNode.value != value);
		
		deleteNode(currentNode.value);
		return currentNode;
	}


public static void main(String[] args){
	
	//create new Binary Tree
	BinaryTree myTree = new BinaryTree();
	
	myTree.insertNode(85);
	myTree.insertNode(25);
	myTree.insertNode(75);
	myTree.insertNode(15);
	myTree.insertNode(30);
	myTree.insertNode(50);
	
	System.out.println(myTree);


}
}

class Node {
	int value;
	
	Node left;
	Node right;
	
	Node(int value) {
		this.value = value;
	}
}