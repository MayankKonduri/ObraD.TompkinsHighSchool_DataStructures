import java.io.IOException;
import java.io.ObjectInputStream;
public class ConnectFourClientListener implements Runnable{
    private ObjectInputStream inputStream;
    private ConnectFourFrame frame;

    public ConnectFourClientListener(ObjectInputStream inputStream, ConnectFourFrame frame){
        this.inputStream = inputStream;
        this.frame = frame;
    }
    public void run()
    {
        try{
            while(true){
                ConnectFourCommandFromServer command = (ConnectFourCommandFromServer) inputStream.readObject();
                frame.updateBoard(command.getBoard());
            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
