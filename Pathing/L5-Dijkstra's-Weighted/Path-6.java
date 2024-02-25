import java.util.*;
public class Path{
    public static int dijkstras(String[] edges, String vertices, char start, char end){
        int n = vertices.length();
        List<Node>[] adjacentList = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adjacentList[i] = new ArrayList<>();
        }
        for(String edge: edges)
        {
            char from = edge.charAt(0);
            char to = edge.charAt(1);
            int weight = Integer.parseInt(edge.substring(2));
            int fromIndex = vertices.indexOf(from);
            int toIndex = vertices.indexOf(to);
            adjacentList[fromIndex].add(new Node(to, weight));
        }
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        d[startIndex] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        minHeap.offer(new Node(start, 0));

        while(!minHeap.isEmpty())
        {
            Node curr = minHeap.poll();
            if(curr.getLocation() == end)
            {
                return d[endIndex];
            }
            int currIndex = vertices.indexOf(curr.getLocation());
            for(Node next: adjacentList[currIndex])
            {
                int nD = d[currIndex] + next.getDistance();
                int nI = vertices.indexOf(next.getLocation());

                if(nD<d[nI])
                {
                    d[nI] = nD;
                    minHeap.offer(new Node(next.getLocation(), nD));
                }
            }
        }
        return -1;
    }
}