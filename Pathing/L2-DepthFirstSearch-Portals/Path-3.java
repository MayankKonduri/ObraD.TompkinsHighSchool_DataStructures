// Add Code Here
import java.awt.Point;

public class Path{
    private static final int[] Rows = {-1,0,0,1};
    private static final int[] Column = {0,-1,1,0};

    public static boolean depthFirstSearch(char[][] maze)
    {
        int r = maze.length;
        int c = maze[0].length;

        Point start = null;
        for(int i =0; i<r;i++){
            for(int j=0; j<c;j++)
            {
                if(maze[i][j]=='S')
                {
                    start = new Point(i,j);
                    break;
                }
            }
        
        if(start!=null)
        {
            break;
        }
        }
        if(start==null)
        {
            return false;
        }
        boolean visited[][] = new boolean[r][c];
        return DFSHelper(maze, visited, start.x, start.y, r, c);
    }
    private static boolean DFSHelper(char[][] maze, boolean [][] visited, int row, int column, int rs, int cs){
        if(maze[row][column]=='E')
        {
            return true;
        }
        visited[row][column]=true;
        //maze[row][column]='-';
        
        char curr = maze[row][column];
        if(Character.isUpperCase(curr))
        {
            char portal = Character.toLowerCase(curr);
            for(int i=0;i<rs;i++)
            {
                for(int j=0;j<cs;j++)
                {
                    if(maze[i][j] == portal && !visited[i][j]){
                        if(DFSHelper(maze,visited, i,j,rs,cs)){
                            return true;
                        }
                    }
                }
            }
        } 
        for(int i=0; i<4;i++)
        {
            int nR = row+Rows[i];
            int nC = column+Column[i];
            if(isValidMove(maze,visited,nR,nC,rs,cs))
            {
                if(DFSHelper(maze,visited,nR,nC,rs,cs))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isValidMove(char[][] maze, boolean[][] visited, int row, int column, int rs, int cs)
    {
        return(row>=0&&row<rs&&column>=0&&column<cs&&maze[row][column]!='W'&&!visited[row][column]);
    }
    public static void main(String[] args)
    {

    }
}