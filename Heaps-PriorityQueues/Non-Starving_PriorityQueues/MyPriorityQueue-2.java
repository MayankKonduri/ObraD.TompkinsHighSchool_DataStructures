public class MyPriorityQueue<E extends Comparable> implements PriorityQueueInterface<E>{
    public MinHeap<E> mH;
    public MyPriorityQueue(){
        mH = new MinHeap<>();
    }
    public boolean offer(E o)
    {
        return mH.insert(o);
    }
    public E poll()
    {
        return mH.remove();
    }
    public int size()
    {
        return mH.size();
    }
    public boolean isEmpty()
    {
        return mH.isEmpty();
    }
    public void clear()
    {
        mH.clear();
    }
    public E get(int x)
    {
        return mH.get(x);
    }
    public E element()
    {
        if(mH.isEmpty())
        {
            return null;
        }
        else
        {
            return mH.get(0);
        }
    }
    public String toString()
    {
        return mH.toString();
    }
}