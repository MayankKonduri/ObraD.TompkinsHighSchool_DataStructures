import java.util.*;
public class Challenge{
    public static int[] fewest(int count)
    {
        int[] array = new int[10];
        int penny =0;
        int nickel=0;
        int dime = 0;
        int quarter =0;
        int one =0;
        int five = 0;
        int ten=0;
        int twenty=0;
        int fifty=0;
        int hundred = 0;
        int i=0;
        if(count>=10000)
        {
            for(i=count;i>=10000;i-=10000)
            {
                hundred++;
            }
            count = i;
        }
        if(count>=5000)
        {
            for(i = count;i>=5000;i-=5000)
            {
                fifty++;
            }
            count = i;
        }
        if(count>=2000)
        {
            for(i = count;i>=2000;i-=2000)
            {
                twenty++;
            }
            count = i;
        }
        if(count>=1000)
        {
            for(i = count;i>=1000;i-=1000)
            {
                ten++;
            }
            count = i;
        }
        if(count>=500)
        {
            for(i=count;i>=500;i-=500)
            {
                five++;
            }
            count = i;
        }
        if(count>=100)
        {
            for(i = count;i>=100;i-=100)
            {
                one++;
            }
            count = i;
        }
        if(count>=25)
        {
            for(i=count;i>=25;i-=25)
            {
                quarter++;
            }
            count = i;
        }
        if(count>=10)
        {
            for(i = count;i>=10;i-=10)
            {
                dime++;
            }
            count = i;
        }
        if(count>=5)
        {
            for(i = count;i>=5;i-=5)
            {
                nickel++;
            }
            count = i;
        }
        if(count>=1)
        {
            for(i = count;i>=1;i-=1)
            {
                penny++;
            }
        }
        array[0] = penny;
        array[1] = nickel;
        array[2] = dime;
        array[3] = quarter;
        array[4] = one;
        array[5] = five;
        array[6] = ten;
        array[7] = twenty;
        array[8] = fifty;
        array[9] = hundred;
        return array;
    }
    public static void Main(String[] args)
    {
        
    }
}