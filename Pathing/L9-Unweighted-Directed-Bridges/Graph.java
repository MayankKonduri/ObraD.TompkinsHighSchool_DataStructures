import java.util.*;

public class Graph{
    public static ArrayList<String> bridges(String[] edges, String vertices)
    {
        ArrayList<String> result = new ArrayList<>();
        for(String e: edges)
        {
            ArrayList<String> mE = removeE(edges, e);
            if(!isValid(mE, vertices))
            {
                result.add(e);
            }
        }
        return result.isEmpty() ? null:result;
    }
    public static ArrayList<String> removeE(String[] edges, String r)
    {
        ArrayList<String> mE = new ArrayList<>();
        for(String e: edges)
        {
            if(!e.equals(r))
            {
                mE.add(e);
            }
        }
        return mE;
    } 
    public static boolean isValid(ArrayList<String> edges, String vertices){
        HashSet<Character> visit = new HashSet<>();
        dfs(edges,vertices.charAt(0), visit);
        for(char v: vertices.toCharArray())
        {
            if(!visit.contains(v))
            {
                return false;
            }
        }
        return true;
    }
    public static void dfs(ArrayList<String> edges, char st, HashSet<Character> visit)
    {
        visit.add(st);
        for(String e: edges)
        {
            if(e.charAt(0)==st && !visit.contains(e.charAt(1)))
            {
                dfs(edges,e.charAt(1),visit);
            }
            else if(e.charAt(1)==st && !visit.contains(e.charAt(0)))
            {
                dfs(edges,e.charAt(0),visit);
            }
        }
    }
}