import java.util.*;
import java.lang.*;
public class Challenge{
    public static ArrayList<Integer> absoluteDifference(ArrayList<Integer> num1, ArrayList<Integer> num2)
    {
        ArrayList<Integer> finale = new ArrayList<Integer>();
        for(int i=0;i<num1.size();i++){
            finale.add(Math.abs(num1.get(i)-num2.get(i)));
        }
        return finale;
    }
    
}