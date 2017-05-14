
package BST;
import java.util.*;
import java.util.NoSuchElementException;


public class BST<T extends Comparable<T>> {
	public static void main(String[] args) {
		Integer[] a = { 3, 8, 6, 4, 9 };
		BST<Integer> bst = new BST<Integer>();
		for (Integer n : a)
			bst.insert(n);

		bst.preOrderTraversal();
		System.out.println();

		bst.toString();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();

		// testing diameter
		System.out.println("diameter = " + bst.diameter());
		// testing width
		System.out.println("width = " + bst.width());
	}
	public int width()
	   {
	      int max = 0;
	      for(int k = 0; k <= height(); k++)
	      {
	         int tmp = width(root, k);
	         if(tmp > max) max = tmp;
	      }
	      return max;
	   }
	public int width(Node<T> p, int depth)
	   {
	      if(p==null) return 0;
	      else
	      if(depth == 0) return 1;
	      else
	      return width(p.left, depth-1) + width(p.right, depth-1);
	   }
	public int diameter()
	   {
	      return diameter(root);
	   }
	   private int diameter(Node<T> p)
	   {
	      if(p==null) return 0;

	      //the path goes through the root
	      int len1 = height(p.left) + height(p.right) +3;

	      //the path does not pass the root
	      int len2 = Math.max(diameter(p.left), diameter(p.right));

	      return Math.max(len1, len2);
	   }

	private Node<T> root;

	public BST() {
		root = null;
	}

	private int compare(T x, T y) {
		return x.compareTo(y);
	}

	/*****************************************************
	 *
	 * INSERT
	 *
	 ******************************************************/
	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> p, T toInsert) {
		//write your code here
		if(p==null)
			return new Node<T>(toInsert);
		if(compare(toInsert, p.data)==0)
			return p;
		if(compare(toInsert,p.data)<0)
			p.left= insert(p.left,toInsert);
		else
			p.right= insert(p.right,toInsert);
		return p;
	}

	/*****************************************************
	 *
	 * SEARCH
	 *
	 ******************************************************/
	public boolean search(T toSearch) {
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
        if(p==null)
        	return false;
        else if(compare(toSearch,p.data)==0)
        	return true;
        else if(compare(toSearch,p.data)<0)
        	return search(p.left,toSearch);
        return search(p.right,toSearch);
	}

	/*****************************************************
	 *
	 * DELETE
	 *
	 ******************************************************/

	public void delete(T toDelete) {
		root = delete(root, toDelete);
	}

	private Node<T> delete(Node<T> p, T toDelete) {
		if(p==null)  throw new NoSuchElementException("Don't Have Elements");
		else if(compare(toDelete,p.data)<0)
			p.left = delete(p.left,toDelete);
		else if(compare(toDelete,p.data)>0)
			p.right = delete(p.right,toDelete);
		else {
			if(p.left==null)
				return p.right;
			else if(p.right==null)
				return p.left;
			p.data = ahihi(p.left);
			p.left = delete(p.left,p.data);
		}
			
		//write your code here
		return p;
	}	
	private T ahihi(Node<T> p){
		
		while(p.right!=null){
			p = p.right;
			
		}
		return p.data;
	}

	/*************************************************
	 *
	 * TRAVERSAL
	 *
	 **************************************************/

	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private String preOrderHelper(Node<T> r,String res) {  //Node Left Right
		// write your code here
		if(r!=null){
			res =res + String.valueOf(r+ " ");
			res = preOrderHelper(r.left,res);
			res = preOrderHelper(r.right,res);
			
		}
		return res;
	}
	private void preOrderHelper(Node<T> r) {  //Node Left Right
		// write your code here
		if(r!=null){
			System.out.print(r+ " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
			
		}
	}
	@Override
	public String toString(){
		String res="";
		res= preOrderHelper(root,res);
		System.out.println(res);
		return res;
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node<T> r) { // left Node right
		//write your code here
		if(r!=null){
			preOrderHelper(r.left);
			System.out.print(r+ " ");
			preOrderHelper(r.right);
			
		}
	}

	/*************************************************
	 *
	 * MISC
	 *
	 **************************************************/

	public int height() {
		return height(root);
	}

	private int height(Node<T> p) {
		//write your code here
		if(p==null)
			return -1;
		return 1 + Math.max(height(p.left),height(p.right));
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node<T> p) {
		//write your code here
		if(p==null)
			return -1;
		if(p.left==null && p.right ==null)
			return 1;
		return countLeaves(p.left)+countLeaves(p.right);
	}

	/*****************************************************
	 *
	 * the Node class
	 *
	 ******************************************************/

	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data, Node<T> l, Node<T> r) {
			left = l;
			right = r;
			this.data = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public String toString() {
			return data.toString();
		}
	} // end of Node
}// end of BST
