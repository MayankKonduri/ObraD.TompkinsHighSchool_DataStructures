public class Challenge{
    public static boolean balanced(int[][] matrix)
    {
        int s = matrix.length;
        int left=0;
        int right = 0;
        for(int i=0;i<s;i++)
        {
            for(int j=0;j<s;j++)
            {
                if(i==j)
                {
                    continue;
                }
                else if(i>j)
                {
                    left+= matrix[i][j];
                }
                else if(i<j)
                {
                    right += matrix[i][j];
                }
            }
        }
        if(left == right)
        {
            return true;
        }
        else{
            return false;
        }
    }
}