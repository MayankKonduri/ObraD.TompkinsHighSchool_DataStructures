import java.util.*;
import java.awt.*;

public class Path{
    
    public static int lowestFuel(char[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        ArrayList<Node> first = new ArrayList<>();
        Point end = new Point();
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
                if(grid[i][j] == 'S')
                {
                    first.add(new Node(new Point(i,j),0));
                }
                else if(grid[i][j] == 'E')
                {
                    end = new Point(i,j);
                }
                else{
                    first.add(new Node(new Point(i,j),Integer.MAX_VALUE));
                }
            }
        }
       ArrayList<Node> sortz = new ArrayList<>(first);
       Collections.sort(sortz);

        while(!sortz.isEmpty())
        {
            Node curr = sortz.remove(0);
            Point cL = curr.getLocation();
            if(curr.getDistance() == Integer.MAX_VALUE){
                break;
            }
            if(curr.getLocation().equals(end))
            {
                return qSZ(sortz, end);
            }
            int[][] dir = {{-1,-1},{-1,1},{1,-1},{1,1},{0,0},{0,1},{1,0},{-1,0},{0,-1}};

            for(int[] d : dir)
            {
                int nR = cL.x + d[0];
                int nC = cL.y + d[1];

                if(nR>=0 && nR<row && nC>=0 && nC<col)
                {
                   int temp = curr.getDistance();
                   int temp1 = grid[nR][nC]=='P' ? temp : temp+1;
                   recursiveSort(sortz, first, new Point(nR, nC), temp1);
                }
            }
            Collections.sort(sortz);
        }
        return -1;
    }
    private static int qSZ(ArrayList<Node> first, Point end)
    {
        for(Node n: first)
        {
            if(n.getLocation().equals(end)){
                return n.getDistance();
            }
        }
        return -1;
    }

    public static void recursiveSort(ArrayList<Node> Sortz, ArrayList<Node> first, Point loc,int temp1)
    {
        for(Node n: Sortz)
        {
            if(n.getLocation().equals(loc))
            {
                if(temp1<n.getDistance())
                {
                    n.setDistance(temp1);
                    updateFirstL(first, loc, temp1);
                }
            }
        }
    }
    public static void updateFirstL(ArrayList<Node> first, Point loc, int dist)
    {
        for(Node n: first)
        {
            if(n.getLocation().equals(loc))
            {
                n.setDistance(dist);
            }
        }
    }
}