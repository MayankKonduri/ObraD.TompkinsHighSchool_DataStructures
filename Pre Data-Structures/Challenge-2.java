import java.util.*;
public class Challenge{
    public static void commonNeighbors(int[] list){
       int len = list.length;
        int[] fake= new int[len];
        if(list[len-1]==list[len-2])
        {
            fake[len-1] = list[len-1];
        }
        else {
            fake[len-1]=0;
        }
        if(list[0]==list[1])
        {
            fake[0] = list[0];
        }
        else {
            fake[0]=0;
        }
        for(int i=len-2;i>0;i--)
        {
            if((list[i+1] == list[i]) || (list[i-1] == list[i]))
            {
                fake[i] = list[i];
            }
            else{
                fake[i] = 0;
            }
        }
        for(int i=0;i<len;i++)
        {
            list[i] = fake[i];
        }
    }
    public static void Main(String[] args)
    {
        
    }
}