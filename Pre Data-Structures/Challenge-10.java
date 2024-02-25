public class Challenge{
    public static void floodFill(char[][] grid, int col, int row, char toReplace, char newValue)
    {
        //out of bounds check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
        {
            return;
        }
            
        if (grid[row][col] == toReplace) 
            {
                // Replace the  cell with the new value if needed
                grid[row][col] = newValue;

                floodFill(grid, col, row - 1, toReplace, newValue); // checks up
                floodFill(grid, col, row + 1, toReplace, newValue); // checks down
                floodFill(grid, col - 1, row, toReplace, newValue); // checks left
                floodFill(grid, col + 1, row, toReplace, newValue); // checks right
            }
        }
    }
