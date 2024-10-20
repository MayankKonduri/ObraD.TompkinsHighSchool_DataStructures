import java.io.Serializable;
public class ConnectFourCommandFromClient implements Serializable {
    private int column;
    public ConnectFourCommandFromClient(int column){
        this.column = column;
    }
    public int getColumn(){
        return column;
    }
}
