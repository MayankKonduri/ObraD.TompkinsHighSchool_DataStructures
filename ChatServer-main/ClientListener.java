import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class ClientListener implements Runnable {
   private ObjectInputStream inputStream;
   private ChatFrame chatFrame;


   public ClientListener(ObjectInputStream inputStream, ChatFrame chatFrame) {
       this.inputStream = inputStream;
       this.chatFrame = chatFrame;
   }


   public void run() {
       try {
           while (true) {
               MessageToClient message = (MessageToClient) inputStream.readObject();
               if (message.getMessage().equals("exit")) {
                   chatFrame.appendMessage(message.getSender() + " disconnected");
                   chatFrame.removeUser(message.getSender());
               } else {
                   chatFrame.appendMessage(message.getSender() + ": " + message.getMessage());
                   chatFrame.updateUserList(message.getUserList()); 
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
