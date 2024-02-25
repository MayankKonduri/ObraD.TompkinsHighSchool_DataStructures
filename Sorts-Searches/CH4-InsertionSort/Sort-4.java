public class Sort
{
    public static void swap(int[] data, int spot1, int spot2) {
        int temp = data[spot1];
        data[spot1] = data[spot2];
        data[spot2] = temp;
    }
    public static void quickSort(int[] data, int from, int to)
    {
        if(from>=to)
        {
            return;
        }
        int p = (from+to)/2;
        int i = from;
        int j = to;
        while(i<=j)
        {
            if(data[i]<=data[p])
            {
                i++;
            }
            else if(data[j]>=data[p])
            {
                j--;
            }
            else{
                swap(data,i,j);
                i++;
                j--;
            }
        }
        if(p<j)
        {
            swap(data,j,p);
            p=j;
        }
        else if(p>i)
        {
            swap(data,i,p);
            p=i;
        }
        quickSort(data,from,p-1);
        quickSort(data,p+1,to);
    }
    public static void main(String[] args)
    {

    }
}