public class Sort{
    public static void insertionSort(int[] list)
    {
        for(int i=1;i<list.length;i++)
        {
            int temp = list[i];
            int j = i;
            while(j>0 && list[j-1]>temp)
            {
                list[j] = list[j-1];
                j=j-1;
                list[j] = temp;
            }
        }
    }
    public static void main(String[] args)
    {

    }
}