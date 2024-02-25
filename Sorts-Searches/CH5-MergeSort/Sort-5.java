public class Sort
{
    static int[] tempData;
    public static void mergeSort(int[] data, int from, int to)
    {
        if(tempData == null || (tempData.length != data.length))
        {
            tempData = new int[data.length];
        }
        if(to==from)
        {
            return;
        }
        int middle = (from+to)/2;
        mergeSort(data,from,middle);
        mergeSort(data,middle+1,to);
        int i = from;
        int j = middle+1;
        int k = from;
        while(i<=middle && j<=to)
        {
            if(data[i]<data[j])
            {
                tempData[k++] = data[i++];
            }
            else{
                tempData[k++] = data[j++];
            }
        }
        while(i<=middle)
        {
            tempData[k++] = data[i++];
        }
        while(j<=to)
        {
            tempData[k++] = data[j++];
        }
        for(k = from; k<=to;k++)
        {
            data[k] = tempData[k];
        }
    }
    public static void main(String[] args)
    {

    }
}
