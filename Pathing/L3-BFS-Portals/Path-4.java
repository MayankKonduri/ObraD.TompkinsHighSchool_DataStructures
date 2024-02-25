import java.awt.Point;
import java.util.*;

public class Path{
    public int breadthFirstSearch(char[][] maze)
    {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int rows = maze.length;
        int col = maze[0].length;
        Point start = null;
        Point end = null;

        for(int i=0; i<rows; i++)
        {
            for(int j=0;j<col;j++)
            {
                if(maze[i][j]=='S')
                {
                    start = new Point(i,j);
                }
                else if(maze[i][j]=='E')
                {
                    end = new Point(i,j);
                }
            }
        }
        if(start==null||end==null){
            return -1;
        }
        QueueInterface<Point> queue = new MyQueue<Point>();
        boolean[][] visited = new boolean[rows][col];
        queue.offer(start);
        visited[start.y][start.x] = true;
        int step = 0;
        while(!queue.isEmpty())
        {
            int s = queue.size();
            for(int i=0; i<s;i++)
            {
                Point curr = queue.poll();
                if(curr.equals(end))
                {
                    return step;
                }
                for(int k=0;k<4;k++)
                {
                    int nx = curr.x + dx[k];
                    int ny = curr.y + dy[k];
                    if(nx>=0&&nx<col&&ny>=0&&ny<rows&&!visited[ny][nx]&&maze[ny][nx]=='W')
                    {
                        char curC = maze[ny][nx];
                        if(curC>='A'&&curC<='D')
                        {
                            char o = (char) (curC+('a'-'A'));
                            for(int m=0;m<rows;m++)
                            {
                                for(int n=0;n<col;n++)
                                {
                                    if(maze[m][n]==o)
                                    {
                                        nx=n;
                                        ny=m;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(curC>='a'&&curC<='d')
                        {
                            char o = (char) (curC+('a'-'A'));
                            for(int m=0;m<rows;m++)
                            {
                                for(int n=0;n<col;n++)
                                {
                                    if(maze[m][n]==o)
                                    {
                                        nx=n;
                                        ny=m;
                                        break;
                                    }
                                }
                            }
                        }
                        queue.offer(new Point(nx,ny));
                        visited[ny][nx]=true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
   
}