//Add Code Here
import java.util.*;
import java.util.EmptyStackException;
public class MyStack <E> implements StackInterface <E>
{
	private ArrayList <E> data;

    public MyStack()
    {
        data = new ArrayList <E>();
    }

	public E peek()
	{
		if(data.size()==0)
			return null;
		else
			return data.get(data.size()-1);
	}
    public void push(E item)
    {
        data.add(item);
    }
    public E pop()
    {
        if(data.isEmpty())
        {
             throw new EmptyStackException();
        }
        E removed = data.remove(data.size()-1);
        return removed;
    }
    public int size()
    {
        return data.size();
    }
    public boolean isEmpty()
    {
        return data.isEmpty();
    }
    public E get(int i)
    {
        if(i<0 || i>data.size()-1)
        {
            throw new IndexOutOfBoundsException();
        }
        return data.get(i);
    }
    public void clear()
    {
        data.clear();
    }
    public String toString()
    {
        return data.toString();
    }
    
}