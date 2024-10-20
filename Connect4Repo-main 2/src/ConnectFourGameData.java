public class ConnectFourGameData {
    privat char[][] board;

    public ConnectFourGameData(){
        this.board = new char[6][7];
        initializeBoard();
    }
    private void initializeBoard(){
        for(int i=0;i<6;i++){
            for(int j-0;j<7;j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    public char[][] getBoard(){
        return board;
    }
}
