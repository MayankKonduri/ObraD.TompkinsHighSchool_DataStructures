import java.awt.Point;

public class Path{
    public static boolean depthFirstSearch(char[][] maze)
    {
        MyStack<Point> stack = new MyStack<>();
        int r = maze.length;
        int c = maze[0].length;
        boolean[][] visited = new boolean[r][c];
        Point st = null;
        outerloop: //looked this up on how to break loops
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(maze[i][j] == 'S')
                {
                    st = new Point(i,j);
                    break outerloop; //looked this up on how to break loops
                }
            }
        }
        if(st == null)
        {
            return false;
        }
        stack.push(st);

        int[] moveX = {-1,1,0,0};
        int[] moveY = {0,0,-1,1};

        while(!stack.isEmpty())
        {
            Point cur = stack.pop();
            int x = (int) cur.getX();
            int y = (int) cur.getY();

            if(maze[x][y] == 'E')
            {
                return true;
            }
            visited[x][y] = true;

            for(int i = 0; i<4; i++)
            {
                int XX = x + moveX[i];
                int YY = y + moveY[i];

                if(XX>=0 && XX<r && YY>=0 && YY<c && !visited[XX][YY] && maze[XX][YY] != 'W')
                {
                    stack.push(new Point(XX,YY));
                    visited[XX][YY] = true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {

    }
}