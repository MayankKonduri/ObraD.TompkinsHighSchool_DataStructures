// I didn't copy any code or look at anyone, but I did use some instruction (directions) online from "https://www.digitalocean.com/community/tutorials/max-heap-java", so I am redoing it again without using any help to avoid any confusion as you stated in class today (November 7th), sorry about that...

import java.util.*;
public class MinHeap<E extends Comparable<E>> implements HeapInterface<E>{

    private ArrayList<E> h;
    public MinHeap()
    {
        h = new ArrayList<>();
    }
    public boolean insert(E item)
    {
        h.add(item);
        int curr = h.size()-1;
        int par = (curr-1)/2;
        while(curr>0 && h.get(curr).compareTo(h.get(par))<0)
        {
            //swap code
            E temp = h.get(curr);
            h.set(curr, h.get(par));
            h.set(par, temp);
            curr = par;
            par = (curr-1)/2;
        }
        return true;
    }
    public E remove()
    {
        if(isEmpty())
        {
            return null;
        }
        E remov = h.get(0);
        int l = h.size()-1;
        h.set(0, h.get(l));
        h.remove(l);

        // that was remove, now we sort the heap

        int curr = 0;
        int lCh;
        int rCh;
        while(true)
        {
            lCh = curr *2 +1;
            rCh = curr*2 +2;
            int larger = curr;
            if(lCh<h.size() && h.get(lCh).compareTo(h.get(larger))<0)
            {
                larger = lCh;
            }
            if(rCh<h.size() && h.get(rCh).compareTo(h.get(larger))<0)
            {
                larger = rCh;
            }
            if(larger == curr)
            {
                break;
            }
            // swap code
            E temp = h.get(curr);
            h.set(curr, h.get(larger));
            h.set(larger, temp);

            curr = larger;
        }
        return remov;
    }
    public boolean isEmpty()
    {
        return h.isEmpty();
    }
    public int size()
    {
        return h.size();
    }
    public E get(int x)
    {
        if(x>=0 || x<h.size())
        {
            return h.get(x);
        }
        return null;
    }
    public void clear()
    {
        h.clear();
    }
    public String toString()
    {
        return h.toString();
    }
}