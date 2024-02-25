public interface QueueInterface<E>
{
	public boolean offer(E o);
	int size();
	public E element();
	public E get(int x);
	public E poll();
	public boolean isEmpty();
    public void clear();
}