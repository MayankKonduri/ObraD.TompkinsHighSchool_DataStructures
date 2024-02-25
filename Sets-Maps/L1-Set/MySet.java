import java.util.*;
public class MySet<E> implements SetInterface <E>
{
	private ArrayList <E> s;

    public MySet()
    {
        s = new ArrayList <E>();
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
        return s.contains(o);
    }
	public boolean isEmpty(){
        return s.isEmpty();
    }
	public Iterator<E> iterator(){
        return s.iterator();
    }
	public boolean remove(E o){
        if(s.size()==0){
            return false;
        }
        return s.remove(o);
    }
	public int size(){
        return s.size();
    }
    
}