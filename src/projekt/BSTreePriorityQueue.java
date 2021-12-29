package projekt;

public class BSTreePriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {
	
	private TreeNode<T> root;
	private int nbrOfElements;

	public BSTreePriorityQueue() {
		root = null;
		nbrOfElements = 0;
	}

	@Override
	public void clear() {
		 root = null;
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		nbrOfElements = 0;
		return countElements(root);
	}
	
	private int countElements(TreeNode<T> N) {
		 if (N != null) {
		        countElements(N.left);
		        nbrOfElements++;
		        countElements(N.right);
		    }
		 return nbrOfElements;
	}

	@Override
	public void enqueue(T element) {
		if (root != null) {
			addElement(root, element);
		} else {
			root = new TreeNode<T>(element);
		}
		
	}
	
	private void addElement(TreeNode<T> N, T E) {
		if (E.compareTo(N.element) < 0) {
			if (N.left == null) {
				N.left = new TreeNode<T>(E); } 
			else {
				addElement(N.left, E); }
		}
		else {
			if (N.right == null) {
				N.right = new TreeNode<T>(E); }
			else {
				addElement(N.right, E); }
		}
	}

	@Override
	public T dequeue() throws QueueEmptyException{
		T deletedElement;
		if (isEmpty()) { 
			throw new QueueEmptyException();
		}
		
		//Om root är minsta värde
		if (root.left == null) {
			deletedElement = root.element;
			if (root.right == null) {
				root = null;
			} else {
				root = root.right;
			}
			
			return deletedElement;
		}
		
		//Hitta minsta värde
		TreeNode<T> current = root;
		while (current != null) {
			if (current.left.left == null) {
				deletedElement = current.left.element;
				
				if (current.left.right == null) {
					current.left = null;
				} else {
					current.left = current.left.right;
				}
				return deletedElement;
			}
			current = current.left;
		}
		return null;
	}

	@Override
	public T getFront() throws QueueEmptyException{
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		if (root.right == null) {
			return root.element;
		}
		TreeNode<T> current = root;
		while (current != null) {
			if (current.right.right == null) {
				return current.right.element;
			}
			current = current.right;
		}
		return null;
	}
	
	public void printQueue() {
		printElement(root);
	}
	
	private void printElement(TreeNode<T> N) {
		if (N != null) {
			printElement(N.left);
			System.out.print(" " + N.element);
			printElement(N.right);
		}
	}
	
	public class TreeNode<T extends Comparable<? super T>> {
		T element;
		TreeNode<T> left;
		TreeNode<T> right;

		public TreeNode(T element) {
			this(element, null, null);
		}
		
		public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

	}

}
