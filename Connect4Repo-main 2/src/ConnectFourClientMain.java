import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class ConnectFourClientMain {
    public static void main(String[] args){

        try {
            Socket socket = new Socket("127.0.0.1", 8000);


            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

            ConnectFourFrame frame = new ConnectFourFrame(os);

            new Thread(new ConnectFourClientListener(is, frame)).start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
