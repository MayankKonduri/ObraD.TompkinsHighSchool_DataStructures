import java.util.*;
import java.awt.*;

public class Path{
    public static int dijkstras(char[][] grid, ArrayList<TerrainCost> travelCosts)
    {
        int row = grid.length;
        int col = grid[0].length;

        Point start = null, end = null;
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
                if(grid[i][j] == 'S')
                {
                    start = new Point(i,j);
                }
                else if(grid[i][j] == 'E')
                {
                    end = new Point(i,j);
                }
            }
        }
        Node[][] n = new Node[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                n[i][j] = new Node(new Point(i,j),Integer.MAX_VALUE);
            }
        }
        n[start.x][start.y].setDistance(0);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        minHeap.offer(n[start.x][start.y]);

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visit = new boolean[row][col];

        while(!minHeap.isEmpty())
        {
            Node curr = minHeap.poll();
            Point cL = curr.getLocation();
            if(cL.equals(end))
            {
                return curr.getDistance();
            }

            if(visit[cL.x][cL.y])
            {
                continue;
            }
            visit[cL.x][cL.y] = true;

            for(int[] d : dir)
            {
                int nR = cL.x + d[0];
                int nC = cL.y + d[1];

                if(nR>=0 && nR<row && nC>=0 && nC<col && grid[nR][nC] != -1)
                {
                    int cost = getCost(grid[nR][nC], travelCosts);
                    if(cost!=-1)
                    {
                      int nD = curr.getDistance() + cost;
                    
                    if(nD<n[nR][nC].getDistance())
                    {
                        n[nR][nC].setDistance(nD);
                        minHeap.offer(n[nR][nC]);
                    }
                }
            }
            }
        }
        return -1;
    }
    private static int getCost(char type, ArrayList<TerrainCost> travelCosts)
    {
        for(TerrainCost tc: travelCosts)
        {
            if(tc.getType() == type)
            {
                return tc.getCost();
            }
        }
        return -1;
    }
}