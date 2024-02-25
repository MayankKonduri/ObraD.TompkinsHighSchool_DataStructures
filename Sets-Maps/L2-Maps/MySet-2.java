import java.util.*;
public class MySet <E> implements SetInterface <E>
{
	private ArrayList <E> s;

    public MySet()
    {
        s = new ArrayList <E>();
    }
    public Object[] toArray() {
        return s.toArray();
    }
    public boolean add(E o){
        if(s.contains(o)){
            return false;
        }
        s.add(o);
        return true;
    }
	public void clear(){
        s.clear();
    }
	public boolean contains(E o){
        if(s.contains(o)){
            return true;
        }
        return false;
    }
	public boolean isEmpty(){
        return s.isEmpty();
    }
	public Iterator<E> iterator(){
        return s.iterator();
    }
	public boolean remove(E o){
        return s.remove(o);   
    }
	public int size(){
        return s.size();
    }
}