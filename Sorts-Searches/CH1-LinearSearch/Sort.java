public class Sort 
{
    public static void swap(int[] data, int spot1, int spot2) {
        int temp = data[spot1];
        data[spot1] = data[spot2];
        data[spot2] = temp;
    } 
    public static void selectionSort(int[] list)
    {
        for(int a = 0; a<list.length; a++)
        {
            int minIndex = a;
            for(int b = a+1; b<list.length; b++)
            {
                if(list[b]<list[minIndex]){
                minIndex = b;
                }
            }
            swap(list, minIndex, a);
        }
    }
    public static void main(String[] args)
    {

    }
}