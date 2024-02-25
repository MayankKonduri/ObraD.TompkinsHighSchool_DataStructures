import java.util.*;
public class Challenge{
    public static void removeAllInRange(ArrayList<Integer> numbers, int lower, int upper){
        int s = numbers.size();
        ArrayList<Integer> num2 = new ArrayList<>();
        for(int i=0;i<s;i++)
        {
            if(numbers.get(i) < lower || numbers.get(i)>upper)
            {
                num2.add(numbers.get(i));
            }
        }
        numbers.clear();
        for(int j=0;j<num2.size();j++)
        {
            numbers.add(num2.get(j));
        }
    }
}