public class TreeNode<E extends Comparable>
{
	private E data;
	private TreeNode<E> left;
	private TreeNode<E> right;

	public TreeNode(E data)
	{
		this.data 		= data;
		left = right	= null;
	}

	public E getData()
	{ return data; }
	
	public void setData(E data)
	{ this.data = data; }
	
	public TreeNode<E> getLeft()
	{ return left; }
	
	public void setLeft(TreeNode<E> left)
	{ this.left = left; }
	
	public TreeNode<E> getRight()
	{ return right; }
	
	public void setRight(TreeNode<E> right)
	{ this.right = right; }
}  
