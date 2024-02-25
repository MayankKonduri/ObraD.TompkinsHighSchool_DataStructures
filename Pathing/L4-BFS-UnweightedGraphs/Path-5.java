//used your video on Canvas to do it

import java.util.*;

public class Path{
    public static String breadthFirstSearch(String[] edges, String vertices, char start, char end){
        MyQueue<String> q = new MyQueue<>();
        q.offer(Character.toString(start));
        ArrayList<String> v = new ArrayList<>();
        v.add(Character.toString(start));
        while(!q.isEmpty())
        {
            String curr = q.poll();
            char cur = curr.charAt(curr.length()-1);
            if(cur == end)
            {
                return curr;
            }
            for(int i=0;i<edges.length; i++)
            {
                char adj = getAdjacentLocation(cur, edges[i]);
                if(!v.contains(Character.toString(adj))&& adj!=0){
                    String n = curr + adj;
                    v.add(Character.toString(adj));
                    q.offer(n);
                }

            }
        }
        return null;
    }
    public static char getAdjacentLocation(char cur, String edge)
    {
        if(edge.charAt(0)==cur)
        {
            return edge.charAt(1);
        } else if(edge.charAt(1)==cur)
        {
            return edge.charAt(0);
        }
        return 0;
    }
}