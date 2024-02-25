public class Path{
    public static boolean isSolvable(char[][] maze, boolean[][] beenThere, int column, int row)
    {
        //first condition
        if (row < 0 || row >= maze.length || column < 0 || column >= maze[0].length) {
            return false;
        }
        //second condition
        if(maze[row][column] == 'E')
        {
            return true;
        }
        //third condition
        if (maze[row][column] == 'W' || beenThere[row][column]) {
            return false;
        }
        
        //been in the box
        beenThere[row][column] = true;

        //recursive loop
        boolean up = isSolvable(maze, beenThere, column, row - 1);
        boolean down = isSolvable(maze, beenThere, column, row + 1);
        boolean left = isSolvable(maze, beenThere, column - 1, row);
        boolean right = isSolvable(maze, beenThere, column + 1, row);

        //end case if reaches end
        if (up || down || left || right) {
            return true;
        }
        
        //not there
        beenThere[row][column] = false;

        //final result
        return false;

    }
    public static void main(String[] args) {
        
    }
    
}