public class BST<E extends Comparable<E>> implements BST_Interface<E> {
    private TreeNode<E> r;

    public BST()
    {
        r = null;
    }

    public String preOrder()
{
    if(r==null)
        return "[]";    
    return "["+preOrderHelper(r).substring(2)+"]";
}
	
public String preOrderHelper(TreeNode<E> temp)
{
    if(temp==null)
        return "";
    else
        return ", "+temp.getData() + preOrderHelper(temp.getLeft()) + preOrderHelper(temp.getRight());
}

    public String inOrder() {
        if(r==null)
        {
            return "[]";
        }
        return "[" + inOrderHelper(r).substring(2)+"]";
    }

    public String inOrderHelper(TreeNode<E> temp)
    {
        if(temp==null)
        {
            return "";
        }
        else{
            return inOrderHelper(temp.getLeft()) + ", " + temp.getData() + inOrderHelper(temp.getRight());
        }
    }

    public String postOrder() {
        if(r==null)
        {
            return "[]";
        }
        return "[" + postOrderHelper(r).substring(2)+"]";
    }

    private String postOrderHelper(TreeNode<E> temp) {
        if(temp==null)
        {
            return "";
        }
        else{
            return postOrderHelper(temp.getLeft()) + postOrderHelper(temp.getRight()) + ", " + temp.getData();
        }
    }


    public E minValue() {
        if(r == null)
        {
            return null;
        }
        TreeNode<E> cur = r;
        while(cur.getLeft() != null)
        {
            cur = cur.getLeft();
        }
        return cur.getData();
    }

    public E maxValue() {
        if(r == null)
        {
            return null;
        }
        TreeNode<E> cur = r;
        while(cur.getRight() != null)
        {
            cur = cur.getRight();
        }
        return cur.getData();
    }

    public int maxDepth() {
        return maxDepth(r);
    }
    public int height()
    {
        return maxDepth(r) + 1;
    }

    private int maxDepth(TreeNode<E> n)
    {
        if(n==null)
        {
            return 0-1;
        }
        else{
            int l = maxDepth(n.getLeft());
            int r = maxDepth(n.getRight());
            if(l>r)
            {
                return l+1;
            }
            else
            {
                return r+1;
            }
        }
    }

    public void clear() {
        r = null;
    }

    public int size() {
        return size(r);
    }
    
    private int size(TreeNode<E> n)
    {
        if(n==null)
        {
            return 0;
        }
        else{
            return 1 + size(n.getLeft()) + size(n.getRight());
        }
    }

    public boolean isEmpty() {
        return r==null;
    }

    public boolean contains(E data) {
        return contains(r, data);
    }
    
    private boolean contains(TreeNode<E> n, E data)
    {
        if(n==null)
        {
            return false;
        }
        else if(data.compareTo(n.getData()) < 0) 
        {
            return contains(n.getLeft(), data);
        } 
        else if(data.compareTo(n.getData()) > 0) 
        {
            return contains(n.getRight(), data);
        }
        else{
            return true;
        }
    }

    public boolean insert(E data) {
        if(contains(data))
        {
            return false;
        }
        r = insert(r,data);
        return true;
    }

    private TreeNode<E> insert(TreeNode<E> n, E data)
    {
        if(n==null){
        return new TreeNode<E>(data);
        }
        else {
            if (data.compareTo(n.getData()) < 0) 
            {
                n.setLeft(insert(n.getLeft(), data));
            } 
            else if (data.compareTo(n.getData()) > 0) 
            {
                n.setRight(insert(n.getRight(), data));
            }
            return n;
        }
    }

    public boolean remove(E data) {
        if(!contains(data))
        {
            return false;
        }
        r = remove(r,data);
        return true;
    }
    private TreeNode<E> remove(TreeNode<E> n, E data)
    {
        if(n==null){
            return null;
        }
        if(data.compareTo(n.getData())<0)
        {
            n.setLeft(remove(n.getLeft(),data));
        }
        else if(data.compareTo(n.getData())>0)
        {
            n.setRight(remove(n.getRight(),data));
        }
        else{
            if(n.getLeft()==null)
            {
                return n.getRight(); 
            }
            else if(n.getRight()==null)
            {
                return n.getLeft();
            }
            n.setData(fMin(n.getRight()).getData());
            n.setRight(remove(n.getRight(), n.getData()));
        }
        return n;
    }
    private TreeNode<E> fMin(TreeNode<E> n)
    {
        while(n.getLeft()!=null)
        {
            n=n.getLeft();
        }
        return n;
    }
}