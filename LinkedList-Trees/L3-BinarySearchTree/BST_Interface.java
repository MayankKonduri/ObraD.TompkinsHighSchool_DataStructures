public interface BST_Interface<E extends Comparable>
{
	public String preOrder();
	public String inOrder();
	public String postOrder();
	public E minValue();
	public E maxValue();
	public int maxDepth();
	public void clear();
	public int size();
	public boolean isEmpty();
	public boolean contains(E data);
	public boolean insert(E data);
	public boolean remove(E data);
    public int height();
}