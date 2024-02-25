public class Sort
{
    public static void heapSort(int[] list)
    {
      MinHeap<Integer> heap = new MinHeap<Integer>();
      for(int i = 0;i<list.length;i++)
      {
        heap.insert(list[i]);
      }
      for(int j = 0;j<list.length;j++)
      {
        list[j] = heap.remove();
      }
      
    }
    public static void main(String[] args)
    {
        
    }
}