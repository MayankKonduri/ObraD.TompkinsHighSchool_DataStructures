import java.util.*;
public class MyStack<E> implements StackInterface<E>
{
    private ArrayList<E> data;
    public MyStack()
    {
        data = new ArrayList<>();
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
    public E peek()
    {
        if(data.isEmpty())
        {
            throw new EmptyStackException();
        }
        return data.get(data.size()-1);
    }
    public boolean isEmpty()
    {
        return data.isEmpty();
    }
    public int size()
    {
        return data.size();
    }
}