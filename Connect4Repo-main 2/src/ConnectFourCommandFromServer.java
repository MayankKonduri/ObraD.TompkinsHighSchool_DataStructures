import java.io.Serializable;
public class ConnectFourCommandFromServer implements Serializable{
    private char[][] board;

    public ConnectFourCommandFromServer(char[][] board){
        this.board = board;
    }

    public char[][] getBoard(){
        return board;
    }
}
