public class Challenge {
    public static char[][] javaSpiral(int numCols, int numRows) {
        char[][] spiral = new char[numRows][numCols];
        char[] source = {'j', 'a', 'v', 'a'};

        int top = 0;
        int bottom = numRows - 1;
        int left = 0;
        int right = numCols - 1;
        int position = 0;

        while (position < (numRows * numCols)) {
            for (int i = left; i <= right && position < (numRows * numCols); i++) {
                spiral[top][i] = source[position % 4];
                position++;
            }
            top++;

            for (int j = top; j <= bottom && position < (numRows * numCols); j++) {
                spiral[j][right] = source[position % 4];
                position++;
            }
            right--;

            for (int k = right; k >= left && position < (numRows * numCols); k--) {
                spiral[bottom][k] = source[position % 4];
                position++;
            }
            bottom--;

            for (int l = bottom; l >= top && position < (numRows * numCols); l--) {
                spiral[l][left] = source[position % 4];
                position++;
            }
            left++;
        }

        return spiral;
    }

    public static void main(String[] args) {
        
    }
}
