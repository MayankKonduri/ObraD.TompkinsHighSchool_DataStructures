public class LinkedList<E> implements LinkedListInterface<E>
{
    private LLNode<E> head;
    private LLNode<E> tail;
    private int size;

    public LinkedList(E data)
    {
        head = new LLNode<E>(data);
        tail = head;
        size++;
    }
    
    public int size()
    {
        return size;
    }
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public LLNode<E> getFirstNode(){
        return head;
    }
    public LLNode<E> getLastNode(){
        return tail;
    }
    public E getFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        else{
            return head.getData();
        }
    }
    public E getLast()
    {
        if(isEmpty())
        {
            return null;
        }
        else{
            return tail.getData();
        }
    }
    public E removeFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        else{
            E temp = head.getData();
            head = head.getNext();
            size = size-1;
            if(isEmpty())
            {
                tail = null;
            }
            return temp;
        }
    }
    public E removeLast()
    {
        if(isEmpty())
        {
            return null;
        }
        E temp = tail.getData();
        if(size == 1)
        {
            head = null;
            tail = null;
        }
        else{
        LLNode<E> temp1 = head;
        while(temp1.getNext()!= tail)
        {
            temp1 = temp1.getNext();
        }
        temp1.setNext(null);
        tail = temp1;
    }
    size --;
    return temp;
    }
    public void addFirst(E data)
    {
        LLNode<E> neww = new LLNode<E>(data);
        neww.setNext(head);
        head = neww;
        if(isEmpty())
        {
            tail = neww;
        }
        size++;
    }
    public void addLast(E data)
    {
        LLNode<E> neww = new LLNode<E>(data);
        if(isEmpty())
        {
            head = neww;
            tail = neww;
        }
        else{
            tail.setNext(neww);
            tail = tail.getNext();
        }
        size++;
    }
    public E get(int x){
        LLNode<E> temp = head;
        for (int i=0; i<x; i++)
        {
            temp = temp.getNext();
        }
        return temp.getData();
    }
	public void add(int x, E data){
        if(x<0 || x>size)
        {
            
        }
        else if(x==0)
        {
            addFirst(data);
        }
        else if(x==size)
        {
            addLast(data);
        }
        else {
            LLNode<E> neww = new LLNode<E>(data);
            LLNode<E> temp = head;
            for(int i =0; i<x-1;i++)
            {
                temp = temp.getNext();
            }
            neww.setNext(temp.getNext());
            temp.setNext(neww);
            size++;
        }
    }
	public E remove(int x){
        if(x<0 || x>=size)
        {
            return null;
        }
        if(x==0)
        {
            return removeFirst();
        }
        if(x==size-1)
        {
            return removeLast();
        }
        else{
            LLNode<E> temp = head;
            for(int i=0;i<x-1;i++)
            {
                temp = temp.getNext();
            }
            E temp1 = temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
            size--;
            return temp1;
        }
    }
	public E set(int x, E data)
    {
        if(x<0 || x>=size)
        {
            return null;
        }
        else{
            LLNode<E> temp = head; 
        for(int i=0; i<x;i++)
        {
            temp = temp.getNext();
        }
        E temp1 = temp.getData();
        temp.setData(data);
        return temp1;
    }}
    public String toString()
    {
        if(isEmpty())
        {
            return "[]";
        }
        String temp = "[";
        LLNode<E> temp1 = head;
        while(temp1 != null)
        {
            temp += temp1.getData();
            if(temp1.getNext() != null)
            {
                temp += ", ";
            }
            temp1 = temp1.getNext();
        }
        temp+= "]";
        return temp;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
}