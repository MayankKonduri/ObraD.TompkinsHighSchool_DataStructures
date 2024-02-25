import java.util.*;
import java.util.EmptyStackException;
public class MyQueue <E> implements QueueInterface <E>
{
	private ArrayList <E> data;

    public MyQueue()
    {
        data = new ArrayList <E>();
    }

	public E element()
	{
		if(data.size()==0)
			return null;
		else
			return data.get(0);
	}
	public boolean offer(E o)
    {
        data.add(o);
        return true;
    }
    public E poll()
    {
        if(data.isEmpty())
        {
             throw new EmptyStackException();
        }
        E removed = data.remove(0);
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