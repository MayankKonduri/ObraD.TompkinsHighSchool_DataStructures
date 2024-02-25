public class DoublyCircularLinkedList<E> implements DoublyCircularLinkedListInterface<E>
{
    private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;

    public DoublyCircularLinkedList(E data)
    {
        DLLNode<E> neww = new DLLNode<E>(data);
        head = neww;
        tail = neww;
        head.setNext(tail);
        tail.setPrev(head);
        size = 1;
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
    public DoublyCircularLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public DLLNode<E> getFirstNode(){
        return head;
    }
    public DLLNode<E> getLastNode(){
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
            head.setPrev(tail);
            tail.setNext(head);
            size = size-1;
            if(isEmpty())
            {
                head = null;
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
        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
    }
    size --;
    return temp;
    }

    public void addFirst(E data)
    {
        DLLNode<E> neww = new DLLNode<E>(data);
        if(isEmpty())
        {
           head = neww;
           tail = neww;
           head.setNext(tail);
           tail.setPrev(head); 
        }
        else{
            neww.setNext(head);
            neww.setPrev(tail);
            head.setPrev(neww);
            tail.setNext(neww);
            head = neww;
        }
        size++;
    }
    public void addLast(E data)
    {
        DLLNode<E> neww = new DLLNode<E>(data);
        if(isEmpty())
        {
           head = neww;
           tail = neww;
           head.setNext(tail);
           tail.setPrev(head); 
        }
        else{
            neww.setNext(head);
            neww.setPrev(tail);
            head.setPrev(neww);
            tail.setNext(neww);
            tail = neww;
        }
        size++;
    }
    public E get(int x){
        if(x<0 || x>=size)
        {
            return null;
        }
        DLLNode<E> temp = head;
        for (int i=0; i<x; i++)
        {
            temp = temp.getNext();
        }
        return temp.getData();
    }
	public void add(int x, E data){
        if(x<0 || x>size)
        {
            return;
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
            DLLNode<E> neww = new DLLNode<E>(data);
            DLLNode<E> temp = head;
            for(int i =0; i<x-1;i++)
            {
                temp = temp.getNext();
            }
            DLLNode<E> next = temp.getNext();
            neww.setNext(next);
            neww.setPrev(temp);
            temp.setNext(neww);
            next.setPrev(neww);
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
            DLLNode<E> temp = head;
            for(int i=0;i<x;i++)
            {
                temp = temp.getNext();
            }
            DLLNode<E> prev = temp.getPrev();
            DLLNode<E> next = temp.getNext();    
            prev.setNext(next);
            next.setPrev(prev);
            size--;
            return temp.getData();            
            }
    }
	public E set(int x, E data)
    {
        if(x<0 || x>=size)
        {
            return null;
        }
        else{
            DLLNode<E> temp = head; 
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
        DLLNode<E> temp1 = head;
        for(int i=0; i<size;i++)
        {
            temp+= temp1.getData();
            if(i<size-1)
            {
                temp += ", ";
            }
            temp1 = temp1.getNext();
        }
        temp+= "]";
        return temp;
    }
    public String backwardsToString() {
        if(isEmpty())
        {
            return "[]";
        }
        String temp = "[";
        DLLNode<E> temp1 = tail;
        for(int i=0; i<size;i++)
        {
            temp+= temp1.getData();
            if(i<size-1)
            {
                temp += ", ";
            }
            temp1 = temp1.getPrev();
        }
        temp+= "]";
        return temp;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}