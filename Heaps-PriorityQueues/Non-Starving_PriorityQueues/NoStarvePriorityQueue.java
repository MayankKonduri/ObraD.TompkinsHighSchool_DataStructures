public class NoStarvePriorityQueue<E> extends MyPriorityQueue<PriorityNode<E>>
{
    public PriorityNode<E> poll()
    {
        if(isEmpty())
        {
            return null;
        }
        for(int i=0;i<size();i++)
        {
            PriorityNode<E> n = mH.get(i);
            int newPrior = n.getPriority()-1;
            n.setPriority(newPrior);
        }
        return mH.remove();
    }
}