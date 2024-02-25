import java.util.*;
import java.lang.*;
public class Challenge{
    public static int uniqueCount(int[] array){
        int len = array.length;
        int temp = array.length;
        int r=0;
        for(int x=0;x<len;x++)
        {
            r=0;
            for(int y=x;y<len;y++)         
            {
                if(x!=y && array[x] == array[y])
                {
                    r++;
                    break;
                }
            }
            if(r>0)
            {
                temp--;
            }
        }
                    return temp;

    }
        public static void Main(String[] args)
        {
            
        }
    }

